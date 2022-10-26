public class Lista {
    private int[] vetor_elementos;
    private int numero_elementos;

    public Lista(int tamanho_lista){
        vetor_elementos = new int[tamanho_lista];
        numero_elementos = 0;
    }

    public boolean listaVazia(){
        if(numero_elementos == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean listaCheia(){
        if(numero_elementos >= vetor_elementos.length){
            return true;
        }
        else {
            return false;
        }
    }

    public void adicionarFinal(int elemento){
        if(listaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else {
            int indice = numero_elementos;
            vetor_elementos[indice] = elemento;
            numero_elementos = numero_elementos + 1;
        }
    }

    public int removerFinal() {
        if(listaVazia()){
            System.out.println("Estrutura Vazia!");
            return 0;
        }
        else {
            int indice = numero_elementos - 1;
            int elemento_removido = vetor_elementos[indice];
            numero_elementos = indice;
            return elemento_removido;
        }
    }

    public void adicionarInicio(int elemento){
        if(listaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else{
            for(int indice = numero_elementos; indice > 0; indice--){
                vetor_elementos[indice] = vetor_elementos[indice - 1];
            }
            vetor_elementos[0] = elemento;
            numero_elementos = numero_elementos + 1;
        }
    }

    public int removerInicio(){
        if(listaVazia()){
            System.out.println("Estrutura Vazia!");
            return 0;
        }
        else {
            int elemento_removido = vetor_elementos[0];
            for(int indice = 1; indice <= numero_elementos -1; indice++){
                vetor_elementos[indice-1] = vetor_elementos[indice];
            }
            numero_elementos = numero_elementos - 1;
            return elemento_removido;
        }
    }

    public void adicionarPosicao(int e, int i){
        if(listaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else {
            if (i <= 0){
                this.adicionarInicio(e);
            }
            else if(i >= numero_elementos){
                this.adicionarFinal(e);
            }
            else {
                for (int indice = this.numero_elementos; indice > i; indice--){
                    this.vetor_elementos[indice] = this.vetor_elementos[indice - 1];
                }
                this.vetor_elementos[i] = e;
                this.numero_elementos = this.numero_elementos + 1;
            }
        }
    }

    public int removerPosicao(int posicao) {
        if(listaVazia()){
            System.out.println("Estrutura Vazia!");
            return 0;
        }
        else{
            if(posicao <= 0) {
                return removerInicio();
            }
            else if (posicao >= this.numero_elementos) {
                return removerFinal();
            }
            else {
                int elemento_removido = this.vetor_elementos[posicao];
                for(int indice = posicao; indice < (this.numero_elementos - 1); indice++){
                    this.vetor_elementos[indice] = this.vetor_elementos[indice+1];
                }
                this.numero_elementos = this.numero_elementos - 1;
                return elemento_removido;
            }
        }
    }

    public void printarLista(){
        for(int indice = 0; indice < this.numero_elementos; indice++){
            int elemento = this.removerInicio();
            this.adicionarFinal(elemento);
            System.out.println(elemento);
        }
        System.out.println("Número de elementos = " + this.numero_elementos);

    }

    public int retornarElementoMeio(){
        int elemento_meio = 0;
        for(int indice = 0; indice <= this.numero_elementos; indice++){
            int elemento = this.removerInicio();
            this.adicionarInicio(elemento);
            if(indice == this.numero_elementos/2){
                elemento_meio = this.removerPosicao(indice);
                this.adicionarPosicao(elemento_meio, indice);
            }
        }
        return elemento_meio;
    }
    public void trocaPrimeiroComUltimo(){
        int elemento_inicial = this.removerInicio();
        int elemento_final = this.removerFinal();
        this.adicionarInicio(elemento_final);
        this.adicionarFinal(elemento_inicial);
    }

    public int getPosicao(int posicao){
        int elemento_posicao = 0;
        for(int indice = 0; indice <= this.numero_elementos; indice++){
            int elemento = this.removerInicio();
            this.adicionarInicio(elemento);
            if(indice == posicao){
                elemento_posicao = this.removerPosicao(indice);
                this.adicionarPosicao(elemento_posicao, indice);
            }
        }
        return elemento_posicao;
    }

    public void inverterLista(){
        for(int cont = 0; cont <= this.numero_elementos - 1; cont++){
        this.adicionarPosicao(this.removerFinal(), cont);
        }
    }

    public void removerRepetidos() {
        int valor_referencia;
        int indice = this.numero_elementos - 1;
        while (indice > 0){
        valor_referencia = getPosicao(indice);
        for(int j = indice - 1; j >= 0; j--){
            if(valor_referencia == getPosicao(j)){
            this.removerPosicao(j);
            indice--;
            }
        }
        indice--;
        }
    }
}
