public class Pilha {
    private String[] vetor_elementos;
    private int numero_elementos;

    public Pilha(int tamanho){
        vetor_elementos = new String[tamanho];
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

    public void adicionarFinal(String elemento){
        if(pilhaCheia()){
            System.out.println("Estrutura Cheia!");
        }
        else {
            int indice = numero_elementos;
            vetor_elementos[indice] = elemento;
            numero_elementos = numero_elementos + 1;
        }
    }

    public String removerFinal() {
        if(pilhaVazia()){
            System.out.println("Estrutura Vazia!");
            return "";
        }
        else {
            int indice = numero_elementos - 1;
            String elemento_removido = vetor_elementos[indice];
            numero_elementos = indice;
            return elemento_removido;
        }
    }


    public void printarPilha(){
        Pilha auxiliar = new Pilha(numero_elementos);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            String elemento = this.removerFinal();
            auxiliar.adicionarFinal(elemento);
        }
        for(int indice = auxiliar.numero_elementos - 1; indice >= 0; indice--) {
            String elemento = auxiliar.removerFinal();
            System.out.print(elemento + " ");
            this.adicionarFinal(elemento);
        }
        System.out.println("Número de elementos = " + this.numero_elementos);
    }

    public void inverterPilha(){
        Pilha auxiliar = new Pilha(numero_elementos);
        Pilha auxiliar2 = new Pilha(numero_elementos);
        for(int indice = this.numero_elementos - 1; indice >= 0; indice--){
            String elemento = this.removerFinal();
            auxiliar.adicionarFinal(elemento);
        }

        for(int indice = auxiliar.numero_elementos - 1; indice >= 0; indice--) {
            String elemento = auxiliar.removerFinal();
            auxiliar2.adicionarFinal(elemento);
        }
        for(int indice = auxiliar2.numero_elementos - 1; indice >= 0; indice--) {
            String elemento = auxiliar2.removerFinal();
            this.adicionarFinal(elemento);
        }
    }

    public boolean checarPalindromo(String palavra){
        int quantidade_letras = palavra.length();
        String char_original;
        String char_invertida;
        Pilha pilha_invertida = new Pilha(quantidade_letras);
        Pilha pilha_original = new Pilha(quantidade_letras);
        for (int i = 0; i < quantidade_letras; i++){
            pilha_invertida.adicionarFinal(String.valueOf(palavra.charAt(i)));
            pilha_original.adicionarFinal(String.valueOf(palavra.charAt(i)));
        }
        pilha_original.inverterPilha();

        pilha_original.printarPilha();
        pilha_invertida.printarPilha();

        for(int j = 0; j <= quantidade_letras/2; j++){
            char_original = pilha_original.removerFinal();
            char_invertida = pilha_invertida.removerFinal();
            System.out.println("original: " + char_original + " invertido: " + char_invertida);
            if(!char_original.equals(char_invertida)){
                return false;
            }
        }
        return true;
    }

}
