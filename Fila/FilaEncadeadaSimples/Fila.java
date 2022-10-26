public class Fila {
  public No inicio_fila;
  
  public Fila(){
      inicio_fila = null;
  }

  public boolean filaVazia() {
    if(this.inicio_fila == null) {
      return true;
    } else {
      return false;
    }
  }

  public void adicionarFinal(int elemento) {
    No novo = new No(elemento);
    if(filaVazia()){
      this.inicio_fila = novo;
    } else {
      No auxiliar = this.inicio_fila;
      while (auxiliar.proximoNo != null) {
        auxiliar = auxiliar.proximoNo;
      }
      auxiliar.proximoNo = novo;
    }
  }
    public No removerInicio(){
        No removido = null;
        if (filaVazia()) {
            System.out.println("Fila vazia");
        } else {
            removido = this.inicio_fila;
            this.inicio_fila = inicio_fila.proximoNo;
        }
        return removido;
    }

    public void printFila(){
        No auxiliar = this.inicio_fila;
        while (auxiliar != null) {
            System.out.print(auxiliar.elementoArmazenado + " ");
            auxiliar = auxiliar.proximoNo;
        }
        System.out.println();
    }

}