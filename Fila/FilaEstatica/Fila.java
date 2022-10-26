public class Fila {
    private int[] vetor_elementos;
    private int numero_elementos;

    public Fila(int tamanho){
        vetor_elementos = new int[tamanho];
        numero_elementos = 0;
    }

    public boolean filaVazia(){
        if(numero_elementos == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean filaCheia(){
        if(numero_elementos >= vetor_elementos.length){
            return true;
        }
        else {
            return false;
        }
    }

    public void adicionarFinal(int elemento){
        if(filaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else {
            int indice = numero_elementos;
            vetor_elementos[indice] = elemento;
            numero_elementos = numero_elementos + 1;
        }
    }

    public int removerInicio(){
        if(filaVazia()){
            System.out.println("Estrutura Vazia!");
            return 0;
        }
        else {
            int elemento_removido = vetor_elementos[0];
            for(int indice = 1; indice <= numero_elementos -1; indice++){
                vetor_elementos[indice-1] = vetor_elementos[indice];
            }
            numero_elementos = numero_elementos - 1;
            return elemento_removido;
        }
    }


    public void printarFila(){
        for(int indice = 0; indice < this.numero_elementos; indice++){
            int elemento = this.removerInicio();
            this.adicionarFinal(elemento);
            System.out.println(elemento);
        }
        System.out.println("Número de elementos = " + this.numero_elementos);

    }
}
