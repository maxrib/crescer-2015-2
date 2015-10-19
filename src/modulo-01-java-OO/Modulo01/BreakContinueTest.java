import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class BreakContinueTest {
    
    @Test
    public void preencherNumerosComContinue() {
        BreakContinue obj = new BreakContinue();
        obj.preencherComContinue();
        
        assertEquals(new ArrayList<Integer>(
            Arrays.asList(0, 1, 2, 4, 5)
        ), obj.getNumeros());
    }
    
    @Test
    public void preencherNumerosComBreak() {
        BreakContinue obj = new BreakContinue();
        obj.preencherComBreak();
        
        assertEquals(new ArrayList<Integer>(
            Arrays.asList(0, 1, 2)
        ), obj.getNumeros());
    }
}