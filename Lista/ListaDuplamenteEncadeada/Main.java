public class Main {
    public static void main(String[] args) throws EstruturaVaziaException {
        Lista lista = new Lista();
        lista.adicionarInicio(1);
        lista.adicionarInicio(2);
        lista.adicionarInicio(8);
        lista.adicionarInicio(8);
        lista.adicionarInicio(6);
        
        //lista.removerNaPosicao(2);
        //System.out.println(lista.buscarElemento(6));
        //lista.printarLista();
        //lista.removerNoMeio();
        //System.out.println(lista.verificarRepetidos());
        //lista.printarLista();
        //lista.inverterLista();
        //lista.printarLista();
        System.out.println(lista.verificarMaisRepetido());


    }
}
