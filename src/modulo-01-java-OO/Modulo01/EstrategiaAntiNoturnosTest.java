import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAntiNoturnosTest {
    /**
     * 4 Elfos (3 Noturnos + 1 Verde) * 2 Anões = 8 intenções
     * 8 intenções * 0.3 = 2.4 elfos noturnos podem atacar.
     * Só 2 noturnos (parte inteira de 2.4) podem atacar
     **/
    @Test
    public void quatroElfos3Noturnos1VerdeAtacam2AnoesMasSo2NoturnosPodemAtacar() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 80;
        Elfo noturno1 = new ElfoNoturno("Night Elf1");
        Elfo noturno2 = new ElfoNoturno("Night Elf2");
        Elfo noturno3 = new ElfoNoturno("Night Elf3");
        Elfo verde1 = new ElfoVerde("Green 1");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaAntiNoturnos());
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(verde1);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(balin, stalin)));
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(2, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }

    /**
     * 4 Elfos (2 noturnos vivos - 1 noturno morto + 1 Verde) * 2 Anões = 6 intenções
     * 6 intenções * 0.3 = 1.8 elfos noturnos podem atacar.
     * Só 1 noturno (parte inteira de 1.8) pode atacar
     **/
    @Test
    public void quatroElfos3NoturnosSendoUmMortoE1VerdeAtacam2AnoesMasSo1NoturnoPodeAtacar() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 90;
        Elfo noturno1 = new ElfoNoturno("Night Elf1");
        Elfo noturno2 = new ElfoNoturno("Night Elf2");
        Elfo noturno3 = new ElfoNoturno("Night Elf3");
        for (int i = 0; i<90; i++) {
            noturno3.atirarFlecha(new Dwarf());
        }
        Elfo verde1 = new ElfoVerde("Green 1");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaAntiNoturnos());
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(verde1);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(balin, stalin)));
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(1, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }
}
