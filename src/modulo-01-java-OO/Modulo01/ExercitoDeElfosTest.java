import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{
    @Test
    public void alistarElfoBaseNãoAlista() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarDoisElfosBaseNãoAlistaNenhum() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Arwen");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfoVerdeAlista() {
        // Arrange
        Elfo elfo = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfoNoturnoAlista() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfosVerdesENoturnosAlistaTodos() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfosVerdesENoturnosAlistaTodosMenosBase() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        Elfo elfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistar(elfoBase);
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void buscarElfoPeloNomeNãoAlistado() {
        // Arrange
        Elfo esperado = null;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        Elfo obtido = exercito.buscar("John Elf Doe");
        // Assert
        assertEquals(esperado, obtido);
    }

    @Test
    public void buscarElfoAlistado() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(esperado);
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }

    @Test
    public void buscarElfoAlistadoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(esperado);
        exercito.alistar(new ElfoVerde("green elf"));
        exercito.alistar(new ElfoNoturno("Night Elf"));
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }

    @Test
    public void buscaElfosVivos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ArrayList<Elfo> vivosEsperado = new ArrayList<>(Arrays.asList(
                    elfoVivo2, elfoVivo3, elfoVivo1
                ));
        ElfoNoturno elfoMorto1 = new ElfoNoturno("Dead Elf 1");
        ElfoNoturno elfoMorto2 = new ElfoNoturno("Dead Elf 2");
        for (int i = 0; i < 90; i++) {
            elfoMorto1.atirarFlecha(new Dwarf());
            elfoMorto2.atirarFlecha(new Dwarf());
        }
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(elfoMorto1);
        exercito.alistar(elfoMorto2);
        exercito.alistar(elfoVivo1);
        exercito.alistar(elfoVivo2);
        exercito.alistar(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        ArrayList<Elfo> vivos = exercito.buscar(Status.VIVO);
        // Assert
        assertEquals(vivosEsperado, vivos);
    }

    @Test
    public void buscaElfosMortos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoNoturno elfoMorto1 = new ElfoNoturno("Dead Elf 1");
        ElfoNoturno elfoMorto2 = new ElfoNoturno("Dead Elf 2");
        for (int i = 0; i < 90; i++) {
            elfoMorto1.atirarFlecha(new Dwarf());
            elfoMorto2.atirarFlecha(new Dwarf());
        }
        ArrayList<Elfo> mortosEsperados = new ArrayList<>(Arrays.asList(
                    elfoMorto2, elfoMorto1
                ));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(elfoMorto1);
        exercito.alistar(elfoMorto2);
        exercito.alistar(elfoVivo1);
        exercito.alistar(elfoVivo2);
        exercito.alistar(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        ArrayList<Elfo> mortos = exercito.buscar(Status.MORTO);
        // Assert
        assertEquals(mortosEsperados, mortos);
    }
}
