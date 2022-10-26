public class Main {
    public static void main(String[] args) throws EstruturaVaziaException {
        Pilha pilha = new Pilha();
        pilha.adicionarFinal(1);
        pilha.adicionarFinal(2);
        pilha.adicionarFinal(3);
        pilha.adicionarFinal(4);
        pilha.printarLista();
        System.out.println();
        pilha.removerFinal();
        pilha.printarListaCompleta();


    }
}
