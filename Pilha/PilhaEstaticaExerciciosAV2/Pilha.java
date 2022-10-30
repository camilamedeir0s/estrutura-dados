import javax.xml.transform.Source;

public class Pilha {
    private int[] vetor_elementos;
    private int numero_elementos;

    public Pilha(int tamanho){
        vetor_elementos = new int[tamanho];
        numero_elementos = 0;
    }

    public boolean pilhaVazia(){
        if(numero_elementos == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean pilhaCheia(){
        if(numero_elementos >= vetor_elementos.length){
            return true;
        }
        else {
            return false;
        }
    }

    public void adicionarFinal(int elemento){
        if(pilhaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else {
            int indice = numero_elementos;
            vetor_elementos[indice] = elemento;
            numero_elementos = numero_elementos + 1;
        }
    }

    public int removerFinal() {
        if(pilhaVazia()){
            System.out.println("Estrutura Vazia!");
            return 0;
        }
        else {
            int indice = numero_elementos - 1;
            int elemento_removido = vetor_elementos[indice];
            numero_elementos = indice;
            return elemento_removido;
        }
    }


    public void printarPilha(){
        Pilha auxiliar = new Pilha(numero_elementos);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            int elemento = this.removerFinal();
            auxiliar.adicionarFinal(elemento);
        }
        for(int indice = auxiliar.numero_elementos - 1; indice >= 0; indice--) {
            int elemento = auxiliar.removerFinal();
            System.out.print(elemento + " ");
            this.adicionarFinal(elemento);
        }
        System.out.println("Número de elementos = " + this.numero_elementos);
    }

    public void inverterPilha(){
        Pilha auxiliar = new Pilha(numero_elementos);
        Pilha auxiliar2 = new Pilha(numero_elementos);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            int elemento = this.removerFinal();
            auxiliar.adicionarFinal(elemento);
        }

        for(int indice = auxiliar.numero_elementos - 1; indice >= 0; indice--) {
            int elemento = auxiliar.removerFinal();
            auxiliar2.adicionarFinal(elemento);
        }
        for(int indice = auxiliar2.numero_elementos - 1; indice >= 0; indice--) {
            int elemento = auxiliar2.removerFinal();
            this.adicionarFinal(elemento);
        }
    }

    public Pilha ordenarPilha(){
        Pilha ordenada = new Pilha(numero_elementos);
        Pilha auxiliar = new Pilha(numero_elementos);
        int ultimo_elemento = this.removerFinal();
        int elemento_atual;
        ordenada.adicionarFinal(ultimo_elemento);
        for (int i = this.numero_elementos - 1; i >= 0; i--){
            elemento_atual = this.removerFinal();
            if(ultimo_elemento <= elemento_atual){
                ordenada.adicionarFinal(elemento_atual);
                ultimo_elemento = elemento_atual;
            } else {
                while(ultimo_elemento >= elemento_atual){
                    ultimo_elemento = ordenada.removerFinal();
                    auxiliar.adicionarFinal(ultimo_elemento);
                }
                ordenada.adicionarFinal(auxiliar.removerFinal());
                ordenada.adicionarFinal(elemento_atual);
                ultimo_elemento = elemento_atual;
                for(int j = auxiliar.numero_elementos - 1; j >= 0; j--){
                    ordenada.adicionarFinal(auxiliar.removerFinal());
                }
            }
        }

        return ordenada;
    }


    public void eliminarMaior(){
        Pilha aux = new Pilha(numero_elementos);
        int maior = this.removerFinal();
        aux.adicionarFinal(maior);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            int elemento = removerFinal();
            aux.adicionarFinal(elemento);
            if(elemento > maior) {
                maior = elemento;
            }
        }

        for(int indice = aux.numero_elementos - 1; indice >= 0; indice--){
            int elemento = aux.removerFinal();
            this.adicionarFinal(elemento);
            if (elemento == maior) {
                this.removerFinal();
            }
        }

    }

    public void eliminarMenor(){
        Pilha aux = new Pilha(numero_elementos);
        int menor = this.removerFinal();
        aux.adicionarFinal(menor);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            int elemento = removerFinal();
            aux.adicionarFinal(elemento);
            if(elemento < menor) {
                menor = elemento;
            }
        }

        for(int indice = aux.numero_elementos - 1; indice >= 0; indice--){
            int elemento = aux.removerFinal();
            this.adicionarFinal(elemento);
            if (elemento == menor) {
                this.removerFinal();
            }
        }

    }

}
