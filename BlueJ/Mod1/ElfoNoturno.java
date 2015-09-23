import java.util.*;

public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia+=2;
        
        double novaVida = this.vida*0.95;
        
        this.vida = (int)novaVida;
    }
}