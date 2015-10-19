import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNormalTest {
    @Test
    public void estrategia1Elfo2Dwarves() {
        // Arrange
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        ArrayList<Dwarf> alvos = new ArrayList<Dwarf>(
                Arrays.asList(d1, d2)
            );
        ElfoVerde soldado = new ElfoVerde("Green Elf 1");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 100;
        // Act
        exercito.alistar(soldado);
        exercito.atacar(alvos);
        // Assert
        assertEquals(new ArrayList<Elfo>(
                Arrays.asList(soldado)
            ), exercito.getOrdemDoUltimoAtaque());

        assertEquals(vidaEsperada, d1.getVida(), .0);
        assertEquals(vidaEsperada, d2.getVida(), .0);
    }

    @Test
    public void estrategia3Elfos2Dwarves() {
        // Arrange
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        ArrayList<Dwarf> alvos = new ArrayList<Dwarf>(
                Arrays.asList(d1, d2)
            );
        Elfo soldado1 = new ElfoVerde("Green Elf 1");
        Elfo soldado2 = new ElfoNoturno("Green Elf 2");
        Elfo soldado3 = new ElfoVerde("Green Elf 3");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 80;
        // Act
        exercito.alistar(soldado1);
        exercito.alistar(soldado2);
        exercito.alistar(soldado3);
        exercito.atacar(alvos);
        // Assert
        assertEquals(new ArrayList<Elfo>(
                Arrays.asList(soldado3, soldado2, soldado1)
            ), exercito.getOrdemDoUltimoAtaque());

        assertEquals(vidaEsperada, d1.getVida(), .0);
        assertEquals(vidaEsperada, d2.getVida(), .0);
    }

    @Test
    public void estrategia3Elfos2Dwarves2OndasDeAtaque() {
        // Arrange
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        ArrayList<Dwarf> alvos = new ArrayList<Dwarf>(
                Arrays.asList(d1, d2)
            );
        Elfo soldado1 = new ElfoVerde("Green Elf 1");
        Elfo soldado2 = new ElfoNoturno("Green Elf 2");
        Elfo soldado3 = new ElfoVerde("Green Elf 3");
        ArrayList<Elfo> esperado = new ArrayList<Elfo>(Arrays.asList(soldado3, soldado2, soldado1));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 50;
        // Act
        exercito.alistar(soldado1);
        exercito.alistar(soldado2);
        exercito.alistar(soldado3);
        exercito.atacar(alvos);
        exercito.atacar(alvos);
        ArrayList<Elfo> historicoAtaque = exercito.getOrdemDoUltimoAtaque();
        // Assert
        for (Elfo elfo : esperado) {
            assertTrue(historicoAtaque.contains(elfo));
        }

        assertEquals(vidaEsperada, d1.getVida(), .0);
        assertEquals(vidaEsperada, d2.getVida(), .0);
    }
}
