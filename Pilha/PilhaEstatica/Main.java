public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        pilha.adicionarFinal(5);
        pilha.adicionarFinal(9);
        pilha.adicionarFinal(32);
        pilha.adicionarFinal(7);
        pilha.adicionarFinal(2);

        pilha.printarPilha();
        //pilha.inverterPilha();
        //pilha.eliminarMenor();
        pilha = pilha.ordenarPilha();
        pilha.printarPilha();

    }
}
