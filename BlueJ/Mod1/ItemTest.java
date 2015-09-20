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
}