import java.util.Vector;

public class Lista {
    private Vector<Nodo> elementos;
    private int tamanho;

    public Lista () {
        this.elementos = new Vector<Nodo>();
        this.tamanho = 0;
    }

    protected int insert(int posicao, Nodo value) {
        if (posicao < 0 || posicao > (tamanho + 1)) return 0;

        this.elementos.add(posicao, value);
        this.tamanho++; 
        
        return 1;
    };

    protected int delete(int posicao) {
        if (posicao < 0 || posicao > tamanho || tamanho == 0) return 0;

        this.elementos.remove(posicao);
        this.tamanho--;

        return 1;
    }

    protected Nodo get (int posicao) {
        if (posicao < 0 || posicao > tamanho || tamanho == 0) return null;

        return this.elementos.get(posicao);
    }

    public int length () {
        return tamanho;
    }
}