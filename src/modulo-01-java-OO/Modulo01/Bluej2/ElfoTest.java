import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoIniciaComZeroXp(){
        Elfo master = new Elfo("juca",40);
        assertEquals(0, master.getXp());
    }
}