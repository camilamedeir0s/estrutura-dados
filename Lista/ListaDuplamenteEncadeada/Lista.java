public class Lista {
        private No inicioLista;
        private No finalLista;


        public Lista(){
            this.inicioLista = null;
            this.finalLista = null;
        }


        public boolean listaVazia(){
            if (this.inicioLista == null && this.finalLista == null){
                return true;
            }
            else {
                return false;
            }
        }


        public void adicionarInicio(int valor){
            No novo = new No(valor);

            if (!this.listaVazia()){
                this.inicioLista.anterior = novo;
                novo.proximo = this.inicioLista;
            }
            else {
                this.finalLista = novo;
            }
            this.inicioLista = novo;
        }


        public void adicionarFinal(int valor){
            No novo = new No(valor);

            if (this.listaVazia()){
                this.inicioLista = novo;
            }
            else{
                this.finalLista.proximo = novo;
                novo.anterior = this.finalLista;
            }
            this.finalLista = novo;
        }


        public No removerInicio() throws EstruturaVaziaException{
            No removido = null;

            if(this.listaVazia()){
                throw new EstruturaVaziaException();
            }
            else{
                removido = this.inicioLista;
                this.inicioLista = this.inicioLista.proximo;
                this.inicioLista.anterior = null;
                removido.proximo = null;
            }
            return removido;
        }

        public No removerFinal() throws EstruturaVaziaException{
            No removido = null;
            No aux;
            if (this.listaVazia()){
                throw new EstruturaVaziaException();
            }
            else{
                removido = aux = this.inicioLista;
                while(removido.proximo != null){
                    aux = removido;
                    removido = removido.proximo;
                }
                removido.anterior = null;
                aux.proximo = null;
            }
            return removido;
        }

        public void adicionarNaPosicao(int valor, int posicao){
            if(this.listaVazia() || posicao <= 0){
                this.adicionarInicio(valor);
            }
            else{
                No novo = new No(valor);
                No aux1 = this.inicioLista;
                No aux2 = this.inicioLista;
                int indice = 1;
                while(indice<posicao && aux1 != null){
                    aux1 = aux1.proximo;
                    indice++;
                }
                if(aux1 == null){
                    this.adicionarFinal(valor);
                }
                else{
                   
                    if(aux1.proximo != null){
                        aux2 = aux1.proximo;
                        novo.proximo = aux2;
                        aux2.anterior = novo;

                    }
                    novo.anterior = aux1;
                    aux1.proximo = novo;

                }
            }
        }

        public No removerNaPosicao(int posicao) throws EstruturaVaziaException{
            No removido = null;
            No aux;
            if(this.listaVazia() || posicao<=0){
                removido = this.removerInicio();
            }
            else{
                removido = aux = this.inicioLista;
                int indice = 0;
                while(indice<posicao && removido != null){
                    aux = removido;
                    removido = removido.proximo;
                    indice++;
                }
                if (removido == null){
                    removido = this.removerFinal();
                }
                else{
                    aux.proximo = removido.proximo;
                    if(removido.proximo != null){
                        No aux2 = removido.proximo;
                        aux2.anterior = aux;
                    }
                    removido.anterior = removido.proximo = null;
                }
            }
            return removido;
        }
        
        public void printarLista(){
            No noAtual;
            noAtual = inicioLista;
            while(noAtual != null){
                System.out.println(noAtual.valor);
                noAtual = noAtual.proximo;
            }
        }

    public void printarListaCompleta(){
        No noAtual;
        noAtual = inicioLista;
        while(noAtual != null){
            if (noAtual.anterior == null){
                System.out.print("Anterior = null");
            }
            else{
                System.out.print("Anterior = " + noAtual.anterior.valor);
            }
            System.out.print(" - Valor = " + noAtual.valor);
            if (noAtual.proximo == null){
                System.out.println(" - Proximo = null" );
            }
            else{
                System.out.println(" - Proximo = " + noAtual.proximo.valor);
            }
            noAtual = noAtual.proximo;
        }
    }

    public int buscarElemento(int elemento){
        if (listaVazia()){
            return -1;
        }else {
            No noAtual = this.inicioLista;
            int posicao = 0;
            while(noAtual != null){
                if (elemento == noAtual.valor){
                    return posicao;
                }
                posicao ++;
                noAtual = noAtual.proximo;
            }
            return -1;
        }
    }

    public No removerNoMeio() throws EstruturaVaziaException{
        if (this.listaVazia()){
            throw new EstruturaVaziaException();
        } else {
            No noAtual = this.inicioLista;
            No removido;
            int quantidade = 0;
            while(noAtual != null){
                quantidade ++;
                noAtual = noAtual.proximo;
            }
            quantidade = quantidade / 2;
            removido = this.removerNaPosicao(quantidade);
            return removido;
        }
    }

    public boolean verificarRepetidos(){
        if (listaVazia()){
            return false;
        } else {
            No noAtual = this.inicioLista;
            No noVerificando = noAtual.proximo;
            while(noAtual.proximo != null){
                while(noVerificando != null){
                    if (noAtual.valor == noVerificando.valor){
                        return true;
                    }
                    noVerificando = noVerificando.proximo;
                }
                noAtual = noAtual.proximo;
                noVerificando = noAtual.proximo;
            }
            return false;
        }
    }

    public void verificarMaisRepetido() throws EstruturaVaziaException{
        if(listaVazia()) {
            throw new EstruturaVaziaException();
        }
        else {
            if(this.verificarRepetidos()) {
                No noAtual = this.inicioLista;
                No noVerificando = noAtual.proximo;
                Lista lista_repeticoes = new Lista();
                while(noAtual.proximo != null){
                    lista_repeticoes.adicionarFinal(noAtual.valor);
                    lista_repeticoes.adicionarFinal(0);
                    while(noVerificando != null){
                        if (noAtual.valor == noVerificando.valor){
                            int elemento = lista_repeticoes.removerFinal().valor;
                            elemento++;
                            lista_repeticoes.adicionarFinal(elemento);
                        }
                        noVerificando = noVerificando.proximo;
                    }
                    noAtual = noAtual.proximo;
                    noVerificando = noAtual.proximo;
                }
                lista_repeticoes.printarLista();
            }

        }
    }

    public void inverterLista() throws EstruturaVaziaException{
        if (!listaVazia()) {
            No noApoio = this.inicioLista;
            int quantidade = 0;
            while (noApoio != null) {
                quantidade++;
                noApoio = noApoio.proximo;
            }
            for (int i = 0 ; i < quantidade/2 ; i++){
                int remover = quantidade - i - 1;
                No aux = this.removerNaPosicao(remover);
                this.adicionarNaPosicao(aux.valor, i);
                aux = this.removerNaPosicao(i + 1);
                this.adicionarNaPosicao(aux.valor, remover);
            }
        }
    }




}
