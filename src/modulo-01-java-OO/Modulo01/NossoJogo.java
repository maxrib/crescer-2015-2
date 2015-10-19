import java.util.ArrayList;

public class NossoJogo {
    public final static String NOME = "Bahhh of the rings";

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Olá " + args[0] +", bem vindo ao " + NOME);
        }
    }
    
    public void tentarSorteDeTodos(ArrayList<Personagem> personagens) {
        for (Personagem p : personagens) {
            p.tentarSorte();
        }
    }
}