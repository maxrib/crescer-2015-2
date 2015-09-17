import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void anaoMorreCom11Flechadas(){
        int c;
        Dwarf tosco = new Dwarf();
        for(c=0;c<11;c++){
        tosco.receberFlechada();
    }
        assertEquals(Status.MORTO,tosco.getStatus());
    }
    
    @Test
    public void dwarfFlechadaRecebida(){
        //arrange
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 100;
        //act
        gimli.receberFlechada();
        //Assert
        assertEquals(vidaEsperada,gimli.getVida());
    }
}
// AAA
// Arrange
// Act
// Assert