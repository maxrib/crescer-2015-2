import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest{
    
    @Test
    public void itemComNomeNull(){
        Item item = new Item("null",0);
        assertEquals("null",item.getDesc());
    }
    
    @Test
    public void verificarQtdDePoucosItens(){
        Item item = new Item("facão",4);
        assertEquals("facão",item.getDesc());
        assertEquals(4,item.getQtd());
    }
    
    @Test
    public void verificarQtdDeMuitosItens(){
        Item item = new Item("facão",100);
        assertEquals("facão",item.getDesc());
        assertEquals(100,item.getQtd());
    }
    
    @Test
    public void verificarQtdDeItens(){
        Item item = new Item("facão",47);
        assertEquals("facão",item.getDesc());
        assertEquals(47,item.getQtd());
    }
}