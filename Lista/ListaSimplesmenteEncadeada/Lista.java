public class Lista {
  public No inicio_lista;
  
  public Lista(){
      inicio_lista = null;
  }

  public boolean listaVazia() {
    if (this.inicio_lista == null) {
      return true;
    } else {
      return false;
    }
  }

  public void adicionarInicio(int elemento) {
    No novo = new No(elemento);
    if (!listaVazia()){
        novo.proximoNo = this.inicio_lista;
    }
    this.inicio_lista = novo;
  }

  public void adicionarFinal(int elemento) {
    No novo = new No(elemento);
    if(listaVazia()){
      this.inicio_lista = novo;
    } else {
      No auxiliar = this.inicio_lista;
      while (auxiliar.proximoNo != null) {
        auxiliar = auxiliar.proximoNo;
      }
      auxiliar.proximoNo = novo;
    }
  }

    public No removerInicio(){
        No removido = null;
        if (listaVazia()) {
            System.out.println("Lista vazia");
        } else {
            removido = this.inicio_lista;
            this.inicio_lista = inicio_lista.proximoNo;
        }
        return removido;
    }

  public No removerFinal(){
    No removido = null;
    No auxiliar;
    if(listaVazia()){
      System.out.println("Lista vazia");
    } else {
      removido = auxiliar = this.inicio_lista;
      while(removido.proximoNo != null) {
        auxiliar = removido;
        removido = removido.proximoNo;
      }
      auxiliar.proximoNo = null;
    }
      return removido;
  }

  public void adicionarPosicao(int elemento, int posicao) {
    No auxiliar;
    if (this.listaVazia() || posicao <= 1){
      this.adicionarInicio(elemento);
    } else {
      No novo = new No(elemento);
      auxiliar = this.inicio_lista;
      int indice = 1;
      while (indice < posicao && auxiliar != null) {
        auxiliar = auxiliar.proximoNo;
        indice++;
      }
      if(auxiliar == null) {
        this.adicionarFinal(elemento);
      } else {
        novo.proximoNo = auxiliar.proximoNo;
        auxiliar.proximoNo = novo;
      }
    }
  }

  public No removerPosicao(int posicao) {
    No removido = null;
    No auxiliar;
    if(this.listaVazia() || posicao <= 1) {
      removido = this.removerInicio();
    } else {
      removido = auxiliar = this.inicio_lista;
      int indice = 1;
      while(indice < 1 && removido != null) {
        auxiliar = removido;
        removido = removido.proximoNo;
        indice++;
      }
      if(removido == null){
        removido = this.removerFinal();
      } else {
        auxiliar.proximoNo = removido.proximoNo;
      }   
    }
    return removido;
  } 
}