import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtacaUmDwarf() {
        ElfoVerde green = new ElfoVerde("Fandango");
        green.atirarFlecha(new Dwarf());

        assertEquals(2, green.getExperiencia());
    }

    @Test
    public void elfoVerdeAtacaUmDwarfEIrishDwarf() {
        ElfoVerde green = new ElfoVerde("Green Elf");
        Dwarf common = new Dwarf("Common Dwarf");
        IrishDwarf irish = new IrishDwarf();
        green.atirarFlecha(irish);
        green.atirarFlecha(common);
        assertEquals(4, green.getExperiencia());
    }

    @Test
    public void elfoVerdeAdicionaEspadaValiriana() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        sortudo.adicionarItem(new Item(1, "Espada de aço valiriano"));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Espada de aço valiriano"));
        assertEquals(esperado, sortudo.getInventario());
    }

    @Test
    public void elfoVerdeAdicionaItemComDescricaoInvalida() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        sortudo.adicionarItem(new Item(1, "Molejão"));
        Inventario esperado = new Inventario();
        assertEquals(esperado, sortudo.getInventario());
    }

    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroENulo() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        sortudo.adicionarItem(new Item(1, "Arco e Flecha de Vidro"));
        sortudo.adicionarItem(null);
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Arco e Flecha de Vidro"));
        assertEquals(esperado, sortudo.getInventario());
    }
    
    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroEDescricaoNula() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        sortudo.adicionarItem(new Item(1, "Arco e Flecha de Vidro"));
        sortudo.adicionarItem(new Item(1, null));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Arco e Flecha de Vidro"));
        assertEquals(esperado, sortudo.getInventario());
    }

    
}
