import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtacaDwarf() {
        ElfoVerde green = new ElfoVerde("Fandango");
        green.atirarFlecha(new Dwarf());
        
        assertEquals(2,green.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAtacaDwarfEIrishDwarf(){
        ElfoVerde green = new ElfoVerde("green");
        green.atirarFlecha(new IrishDwarf());
        green.atirarFlecha(new Dwarf());
        
        assertEquals(4,green.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAdicionaEspadaValiriana(){
        ElfoVerde sortudo = new ElfoVerde("sortudo");
        Item item = new Item (2,"Espada de aço valiriano");
        Inventario inventario = new Inventario();
        sortudo.adicionarItem(item);
        inventario.adicionarItem(item);

        assertEquals(inventario,sortudo.getInventario());
    }
    
}
