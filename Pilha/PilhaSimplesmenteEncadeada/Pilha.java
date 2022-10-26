public class Pilha {
  public No inicio_pilha;
  
  public Pilha(){
      inicio_pilha = null;
  }

  public boolean pilhaVazia() {
    if (this.inicio_pilha == null) {
      return true;
    } else {
      return false;
    }
  }

  public void adicionarFinal(int elemento) {
    No novo = new No(elemento);
    if(pilhaVazia()){
      this.inicio_pilha = novo;
    } else {
      No auxiliar = this.inicio_pilha;
      while (auxiliar.proximoNo != null) {
        auxiliar = auxiliar.proximoNo;
      }
      auxiliar.proximoNo = novo;
    }
  }

  public No removerFinal(){
    No removido = null;
    No auxiliar;
    if(pilhaVazia()){
      System.out.println("Pilha vazia");
    } else {
      removido = auxiliar = this.inicio_pilha;
      while(removido.proximoNo != null) {
        auxiliar = removido;
        removido = removido.proximoNo;
      }
      auxiliar.proximoNo = null;
    }
      return removido;
  }

  public void printPilha(){
    No auxiliar = inicio_pilha;
    while(auxiliar != null) {
      System.out.print(auxiliar.elementoArmazenado + " ");
      auxiliar = auxiliar.proximoNo;
    }
    System.out.println();
  }

}