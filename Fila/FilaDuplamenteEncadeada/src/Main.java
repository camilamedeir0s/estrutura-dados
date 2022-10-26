public class Main {
    public static void main(String[] args) throws EstruturaVaziaException {
        Fila fila = new Fila();
        fila.adicionarFinal(1);
        fila.adicionarFinal(2);
        fila.adicionarFinal(3);
        fila.adicionarFinal(4);
        fila.printarLista();
        System.out.println();

        fila.removerInicio();
        fila.printarListaCompleta();


    }
}
