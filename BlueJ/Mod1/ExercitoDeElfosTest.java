import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{
    @Test
    public void nãoAlistarElfoBase() {
        Elfo pederneiras = new Elfo("Pederneiras");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistarElfo(pederneiras);
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfoVerde() {
        Elfo elfoso = new ElfoVerde("Elfoso");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfoso.getNome(), elfoso);
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistarElfo(elfoso);
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfoNoturno() {
        Elfo naits = new ElfoNoturno("Naits");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(naits.getNome(), naits);
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistarElfo(naits);
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    
    @Test
    public void buscarElfoAlistado() {
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistarElfo(esperado);
        Elfo obtido = exercito.pesquisarElfo(nomeElfo);
        assertEquals(esperado, obtido);
    }

}