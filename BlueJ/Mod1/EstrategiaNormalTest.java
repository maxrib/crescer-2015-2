import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaNormalTest {
    
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    @Test
    public void exercitoCom2ElfosAtaca2Anoes(){
        ExercitoElfos exercito = new ExercitoElfos();
        Elfo elfo1 = new Elfo("Malaquias");
        Elfo elfo2 = new Elfo("Josnel");
        Dwarf tosquera = new Dwarf("Tosquera");
        Dwarf bolado = new Dwarf("Bolado");
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.add(elfo1);
        elfos.add(elfo2);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add(tosquera);
        dwarves.add(bolado);
        
        estrategia.atacar(elfos,dwarves);        
        
        tosquera.getVida();
        
        //assertEquals(90,tosquera.getVida());
        //assertEquals(90,bolado.getVida());
    }
}
