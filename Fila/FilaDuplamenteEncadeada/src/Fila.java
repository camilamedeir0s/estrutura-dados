public class Fila {
        private No inicioFila;
        private No finalFila;


        public Fila(){
            this.inicioFila = null;
            this.finalFila = null;
        }


        public boolean filaVazia(){
            if (this.inicioFila == null && this.finalFila == null){
                return true;
            }
            else {
                return false;
            }
        }

        public void adicionarFinal(int valor){
            No novo = new No(valor);

            if (this.filaVazia()){
                this.inicioFila = novo;
            }
            else{
                this.finalFila.proximo = novo;
                novo.anterior = this.finalFila;
            }
            this.finalFila = novo;
        }


        public No removerInicio() throws EstruturaVaziaException{
            No removido = null;

            if(this.filaVazia()){
                throw new EstruturaVaziaException();
            }
            else{
                removido = this.inicioFila;
                this.inicioFila = this.inicioFila.proximo;
                this.inicioFila.anterior = null;
                removido.proximo = null;
            }
            return removido;
        }

        public void printarLista(){
            No noAtual;
            noAtual = inicioFila;
            while(noAtual != null){
                System.out.println(noAtual.valor);
                noAtual = noAtual.proximo;
            }
        }

    public void printarListaCompleta(){
        No noAtual;
        noAtual = inicioFila;
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
