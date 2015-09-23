import java.util.*;

public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome, int flechas) {
        super(nome, flechas);
    }
    
    public ElfoVerde(String nome) {
        super(nome);
    }
    
    public void adicionarItem(Item item) {
        
        // C#
        // var validas = new [] { "Espada de aço valiriano", "Arco e Flecha de Vidro" }.ToList();
        
        ArrayList<String> validas = 
            new ArrayList<String>(
                Arrays.asList(new String[] { 
                    "Espada de aço valiriano", "Arco e Flecha de Vidro"
                })
            );
        
        boolean podeAdicionar = item != null && validas.contains(item.getDescricao());
        
        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia++;
    }
}