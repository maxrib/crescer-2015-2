import java.util.*;

public class BreakContinue {
    private ArrayList<Integer> numeros = new ArrayList<Integer>();
    private final int QUANTIDADE = 6, NUMERO = 3;
    
    public void preencherComContinue() {
        for (int i = 0; i < QUANTIDADE; i++) {
            if (i == NUMERO) {
                continue;
            }
            numeros.add(i);
        }
    }
    
    public void preencherComBreak() {
        for (int i = 0; i < QUANTIDADE; i++) {
            if (i == NUMERO) {
                break;
            }
            numeros.add(i);
        }
    }
    
    public ArrayList<Integer> getNumeros() {
        return this.numeros;
    }
}
