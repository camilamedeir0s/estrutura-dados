public class Pilha {
        private No inicioPilha;
        private No finalPilha;


        public Pilha(){
            this.inicioPilha = null;
            this.finalPilha = null;
        }


        public boolean pilhaVazia(){
            if (this.inicioPilha == null && this.finalPilha == null){
                return true;
            }
            else {
                return false;
            }
        }

        public void adicionarFinal(int valor){
            No novo = new No(valor);

            if (this.pilhaVazia()){
                this.inicioPilha = novo;
            }
            else{
                this.finalPilha.proximo = novo;
                novo.anterior = this.finalPilha;
            }
            this.finalPilha = novo;
        }


        public No removerFinal() throws EstruturaVaziaException{
            No removido = null;
            No aux;
            if (this.pilhaVazia()){
                throw new EstruturaVaziaException();
            }
            else{
                removido = aux = this.inicioPilha;
                while(removido.proximo != null){
                    aux = removido;
                    removido = removido.proximo;
                }
                removido.anterior = null;
                aux.proximo = null;
            }
            return removido;
        }

        public void printarLista(){
            No noAtual;
            noAtual = inicioPilha;
            while(noAtual != null){
                System.out.println(noAtual.valor);
                noAtual = noAtual.proximo;
            }
        }

    public void printarListaCompleta(){
        No noAtual;
        noAtual = inicioPilha;
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
