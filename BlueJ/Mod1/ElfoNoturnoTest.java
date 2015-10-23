import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    @Test
    public void elfoNoturnoAtira1Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        elfo.atirarFlecha(dwarf);
        
        assertEquals(3,elfo.getExperiencia());
        assertEquals(95.000,elfo.getVida(),0.001);
    }
    
    @Test
    public void elfoNoturnoAtira5Flechas(){        
        ElfoNoturno elfo = new ElfoNoturno("elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        
        double novaVida = elfo.getVida();
        
        for(int c=0;c<5;c++)
        elfo.atirarFlecha(dwarf);
        
        assertEquals(15,elfo.getExperiencia());
        assertEquals(76,elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoMorreApósAtirarVariasFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        
        while(elfo.getVida()!=0)
            elfo.atirarFlecha(dwarf);
        
        assertEquals(0,elfo.getVida());
        assertEquals(Status.MORTO,elfo.getStatus());
    }
    
}
