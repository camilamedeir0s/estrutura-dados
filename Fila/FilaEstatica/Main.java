public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(4);
        fila.adicionarFinal(1);
        fila.adicionarFinal(2);
        fila.adicionarFinal(3);
        fila.adicionarFinal(4);
        fila.printarFila();
        fila.removerInicio();
        fila.printarFila();
    }
}
