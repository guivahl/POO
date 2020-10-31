public class Pilha extends Lista {
  public int push (Nodo n) {
      return this.insert(0, n);
  } 

  public Nodo pop() {
      int posicao = 0;
      Nodo n = this.get(posicao);
      
      if (n == null) return null;
      
      int deletado = this.delete(posicao);
      
      if (deletado == 0) return null;

      return n;
  }
}