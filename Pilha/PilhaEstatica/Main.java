public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(3);
        pilha.adicionarFinal(1);
        pilha.adicionarFinal(2);
        pilha.adicionarFinal(3);
        pilha.printarPilha();
        pilha.inverterPilha();
        pilha.printarPilha();

    }
}
