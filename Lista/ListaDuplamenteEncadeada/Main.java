public class Main {
    public static void main(String[] args) throws EstruturaVaziaException {
        Lista lista = new Lista();
        lista.adicionarInicio(6);
        lista.adicionarInicio(6);
        lista.adicionarInicio(5);
        lista.adicionarInicio(9);
        lista.adicionarInicio(1);
        //lista.removerNaPosicao(2);
        //System.out.println(lista.buscarElemento(6));
        //lista.printarLista();
        //lista.removerNoMeio();
        System.out.println(lista.verificarRepetidos());
        //lista.printarLista();
        //lista.printarListaCompleta();
        //lista.inverterLista();
        //lista.printarLista();
        lista.verificarMaisRepetido();


    }
}
