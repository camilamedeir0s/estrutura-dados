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
                    aux2 = aux1.proximo;
                    novo.anterior = aux1;
                    novo.proximo = aux2;
                    aux1.proximo = novo;
                    aux2.anterior = novo;
//                    aux2 = aux1.anterior;
//                    novo.anterior = aux2;
//                    novo.proximo = aux1;
//                    novo.proximo = aux.proximo;
//                    aux.proximo = novo;
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
                    No aux2 = removido.proximo;
                    aux2.anterior = aux;
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

}
