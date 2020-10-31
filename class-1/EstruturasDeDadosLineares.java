
public class EstruturasDeDadosLineares {
    public static final String RESET = "\u001B[0m";
    
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\033[0;31m"; 
    public static final String CYAN = "\033[0;36m";

    public static void main(String[] args) {
        System.out.println(colorize(CYAN, "====== TESTES - INICIO ======\n\n" ));

        EstruturasDeDadosLineares.testPilha();
        EstruturasDeDadosLineares.testFila();

        System.out.println(colorize(GREEN, "All tests passed!\n" ));
        System.out.println(colorize(CYAN, "====== TESTES - FIM ======\n\n" ));
    }

    private static String colorize(String colour, String message) {
        return colour + message + RESET;
    }

    private static void assertTrue(boolean passed, String description) {
        System.out.print(description);
        if (passed) {
            System.out.println(": " + colorize(GREEN, "Passed!"));
        } else {
            System.out.println(": " + colorize(RED, "Failed!"));
            System.exit(1);
        };
    }

    private static void testPilha () {
        System.out.println("=== PILHA - INICIO ===\n");

        Pilha pilha = new Pilha();
        Nodo nodo = new Nodo(1);

        System.out.println("\nUma pilha com um elemento...");

        assertTrue(pilha.push(nodo) == 1, "Uma pilha vazia retém o valor inserido como seu topo");        

        Nodo popped = pilha.pop();
        
        assertTrue(popped != null, "O primeiro elemento inserido não é nulo");
        assertTrue(nodo.getValue() == popped.getValue(), "O primeiro elemento inserido é o primeiro a sair");
        assertTrue(pilha.pop() == null, "Pop na pilha vazia resulta em null");

        System.out.println("\nUma pilha com 1, 2, 3...");

        pilha.push(new Nodo(1));
        pilha.push(new Nodo(2));
        pilha.push(new Nodo(3));

        assertTrue(pilha.length() == 3, "Tem tamanho 3");
        assertTrue(pilha.pop().getValue() == 3, "Tem 3 como topo");
        assertTrue(pilha.pop().getValue() == 2, "Depois 2");
        assertTrue(pilha.pop().getValue() == 1, "Depois 1");

        System.out.println("\n=== PILHA - FIM ===\n");
    }

    private static void testFila () {
        System.out.println("=== FILA - INICIO ===\n");

        Fila fila = new Fila();
        Nodo nodo = new Nodo(1);

        System.out.println("\nUma fila com um elemento...");

        assertTrue(fila.enqueue(nodo) == 1, "Uma fila vazia retém o valor inserido");
        assertTrue(fila.dequeue().getValue() == 1, "Uma fila retém o valor inserido como frente");
        assertTrue(fila.dequeue() == null, "Uma fila vazia tem frente null");

        fila.enqueue(new Nodo(3));
        fila.enqueue(new Nodo(2));
        fila.enqueue(new Nodo(4));

        System.out.println("\nUma fila com 3, 2, 4...");
        
        assertTrue(fila.dequeue().getValue() == 3, "Tem 3 como frente");
        assertTrue(fila.dequeue().getValue() == 2, "Depois 2");
        assertTrue(fila.dequeue().getValue() == 4, "Depois 4");
        assertTrue(fila.dequeue() == null, "Depois null");

        System.out.println("\n=== FILA - FIM ===\n");
    }
}