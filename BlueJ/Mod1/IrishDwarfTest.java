import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.adicionarItem(new Item(5, "Lança"));
        dwarf.adicionarItem(new Item(25, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(15005, "Lança"));
        esperado.adicionarItem(new Item(325025, "Poção"));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }
}
