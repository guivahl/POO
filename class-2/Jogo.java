import java.util.Vector;
import java.util.Random;
import java.lang.Math; 

public class Jogo {    
    public static final String RESET = "\u001B[0m";
    
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\033[0;31m"; 
    public static final String YELLOW = "\033[1;33m"; 
    public static final String CYAN = "\033[0;36m";
    public static final String MAGENTA = "\033[1;95m";

    public static void main(String[] args) {
        Vector<Personagem> humanos = iniciaVetorHumanos();
        Vector<Personagem> orcs = iniciaVetorOrcs();

        combateGeral(humanos, orcs);
        
        exibe(orcs, humanos);
    }

    private static Vector<Personagem> iniciaVetorHumanos () {
        Vector<Personagem> humanos = new Vector<Personagem>();

        for (int i = 0; i < 100; i++) {
            humanos.add(criaHumano());
        }

        return humanos;
    }

    private static Vector<Personagem> iniciaVetorOrcs () {
        Vector<Personagem> orcs = new Vector<Personagem>();

        for (int i = 0; i < 100; i++) {
            orcs.add(criaOrc());
        }

        return orcs;
    }

    private static void exibe (Vector<Personagem> Orcs, Vector<Personagem> Humanos) {
        int total_vida_orcs = 0, total_vida_humanos = 0;

        for (int i = 0; i < 100; i++) {
            System.out.println(colorize(CYAN, "Embate " + (i + 1) + ":"));

            System.out.println("Orc: " + Orcs.get(i).toString());
            System.out.println("Humano: " + Humanos.get(i).toString());
            
            if (Humanos.get(i).pontos_vida > Orcs.get(i).pontos_vida)  System.out.println(colorize(GREEN, "Humano venceu!\n"));
            if (Orcs.get(i).pontos_vida > Humanos.get(i).pontos_vida) System.out.println(colorize(RED, "Orc venceu!\n"));
            if (Humanos.get(i).pontos_vida == Orcs.get(i).pontos_vida) System.out.println(colorize(YELLOW, "Empate!\n"));
        
            total_vida_orcs += Orcs.get(i).pontos_vida;
            total_vida_humanos += Humanos.get(i).pontos_vida;
        }

        System.out.println(colorize(MAGENTA, "Resultado final:"));
        System.out.println(
            "Total de vida Humanos: " + total_vida_humanos + "\n" +
            "Total de vida Orcs: " + total_vida_orcs + "\n"
            );

        if (total_vida_humanos > total_vida_orcs) System.out.println(colorize(GREEN, "Humanos venceram!\n"));
        if (total_vida_humanos < total_vida_orcs) System.out.println(colorize(RED, "Orcs venceram!\n"));
        if (total_vida_humanos == total_vida_orcs) System.out.println(colorize(YELLOW, "Empate!\n"));
    }    
    
    private static Personagem criaHumano () {
        int numeroAleatorio = geraNumeroAleatorio();

        if (numeroAleatorio == 0) return new Arqueiro();
        if (numeroAleatorio == 1) return new Soldado();
        
        return new Robo();
    }    

    private static Personagem criaOrc () {
        int numeroAleatorio = geraNumeroAleatorio();

        if (numeroAleatorio == 0) return new Ogro();
        if (numeroAleatorio == 1) return new Mago();
        
        return new Demonio();
    }
 
    private static int geraNumeroAleatorio () {
        Random random = new Random();

        return random.nextInt(3);
    }

    private static void combateGeral(Vector<Personagem> humanos, Vector<Personagem> orcs) {
        int diferenca_vida;
        int numeroAleatorio = geraNumeroAleatorio();
        
        for (int i = 0; i < 100; i++) {
            diferenca_vida = humanos.get(i).compareTo(orcs.get(i));

            if (diferenca_vida > 0) {
                humanos.get(i).ganhaVida(diferenca_vida);
                orcs.get(i).perdeVida(diferenca_vida);
            }

            if (diferenca_vida < 0) {
                humanos.get(i).perdeVida(Math.abs(diferenca_vida));
                orcs.get(i).ganhaVida(Math.abs(diferenca_vida));
            }
        }
    }
    private static String colorize(String colour, String message) {
        return colour + message + RESET;
    }
}