public class Fila extends Lista { 
    public int enqueue(Nodo n) { 
        return this.insert(0, n); 
    }

    public Nodo dequeue() {
        int posicao = this.length() - 1;
        Nodo n = this.get(posicao);
        int deletado = this.delete(posicao);
        
        if (deletado == 0) return null;
        return n;
    }
}