

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Nokia2280Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Nokia2280Test
{
    /**
     * Default constructor for test class Nokia2280Test
     */
    public Nokia2280Test()
    {
    }

    @Test
    public void modeloEhCriadoCorretamente() {
        
        Telefone nokia2280 = new Nokia2280();
        
        String modeloEsperado = "Nokia 2280";
        
        assertEquals(modeloEsperado, nokia2280.getModelo());
    }
    
}
