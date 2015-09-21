import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfNasceVivo() {
        Dwarf balin = new Dwarf();
        assertEquals(Status.VIVO, balin.getStatus());
    }

    @Test
    public void dwarfNasceCom0DeExperiencia() {
        Dwarf balin = new Dwarf();
        assertEquals(0, balin.getExperiencia());
    }

    @Test
    public void dwarfNasceComDataNascimentoPadrão() {
        Dwarf bofur = new Dwarf();
        assertEquals(1, bofur.getDataNascimento().getDia());
        assertEquals(1, bofur.getDataNascimento().getMes());
        assertEquals(1, bofur.getDataNascimento().getAno());
    }

    @Test
    public void dwarfNasceComNomeEDataDeNascimento() {
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(12, bernardin.getDataNascimento().getDia());
        assertEquals(11, bernardin.getDataNascimento().getMes());
        assertEquals(1987, bernardin.getDataNascimento().getAno());
    }

    @Test
    public void dwarfNasceComNome() {
        Dwarf oin = new Dwarf("Oin II");
        assertEquals("Oin II", oin.getNome());
    }

    @Test
    public void dwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha11VezesEVidaÉ0() {
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha7VezesEVidaÉ40() {
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha5VezesESobrevive() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void dwarfRecebeFlecha12VezesEMorre() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void dwarfRecebeFlecha13VezesEVidaFicaZerada() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(0, gimli.getVida());
    }

}
