import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVidaEZeroExperiencia(){
        Dwarf gimli = new Dwarf("gimli");
        assertEquals(110, gimli.getVida());
        assertEquals(0,gimli.getXp());
    }
    
    @Test
    public void dwarfSemNomeNasceCom110DeVidaEZeroExperiencia(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
        assertEquals(0,gimli.getXp());
    }
    
    @Test
    public void dwarfComNomeNullNasceCom110DeVidaEZeroExperiencia(){
        Dwarf gimli = new Dwarf(null);
        assertEquals(null,gimli.getNome());
        assertEquals(110, gimli.getVida());
        assertEquals(0,gimli.getXp());
    }
    
    @Test
    public void dwarf10FlechadasRecebidas(){
        Dwarf gimli = new Dwarf("Malaquias");
        int c,vidaEsperada = 10;
            for(c=0;c<10;c++){
                gimli.receberFlechada();
            }
        assertEquals(vidaEsperada,gimli.getVida());
    }
    
    @Test
    public void anaoMorreCom11Flechadas(){
        int c;
        Dwarf tosco = new Dwarf("gimli");
        for(c=0;c<11;c++){
        tosco.receberFlechada();
    }
        assertEquals(Status.MORTO,tosco.getStatus());
    }
    
    @Test
    public void anaoPermaneceComZeroDeVidaApósVáriasFlechadas(){
        int c;
        Dwarf tosco = new Dwarf("tosco");
        for(c=0;c<100;c++){
        tosco.receberFlechada();
    }
        assertEquals(0,tosco.getVida());
    }
    
    @Test
    public void dwarfFlechadaRecebida(){
        //arrange
        Dwarf gimli = new Dwarf("Malaquias");
        int vidaEsperada = 100;
        //act
        gimli.receberFlechada();
        //Assert
        assertEquals(vidaEsperada,gimli.getVida());
    }
    
    @Test
    public void dwarfSemNomeVerficarDataNascimento(){
        Dwarf anao = new Dwarf();
        assertEquals("1/1/1",anao.getNascimento());
    }
    
    @Test
    public void dwarfComNomeVerficarDataNascimento(){
        Dwarf anao = new Dwarf("anao");
        assertEquals("anao",anao.getNome());
        assertEquals("1/1/1",anao.getNascimento());
    }
    
    @Test
    public void dwarfComNomeNullVerficarDataNascimento(){
        Dwarf anao = new Dwarf(null);
        assertNull(anao.getNome());
        assertEquals("1/1/1",anao.getNascimento());
    }
}
// AAA
// Arrange
// Act
// Assert