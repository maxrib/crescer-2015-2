import java.util.ArrayList;

public class TheGame {
    public final static String NOME = "Lord of the Pampas";

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Olá " + args[0] +", bem-vindo ao " + NOME);
        }
    }
    
}