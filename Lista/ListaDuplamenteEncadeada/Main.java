public class Main {
    public static void main(String[] args) throws EstruturaVaziaException {
        Lista lista = new Lista();
        lista.adicionarInicio(5);
        lista.adicionarInicio(6);
        lista.adicionarInicio(3);
        lista.adicionarInicio(4);
        lista.adicionarFinal(1);
        lista.printarLista();
        System.out.println();
        lista.removerNaPosicao(2);
        lista.printarListaCompleta();


    }
}
