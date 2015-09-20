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
    
    @Test
    public void elfoComNomeNasceCom42Flechas(){
        Elfo zoreia = new Elfo("zoreia");
        assertEquals(42,zoreia.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeNull(){
        Elfo master = new Elfo(null);
        assertNull(master.getNome());
    }
    
    @Test
    public void elfoCriadoComNomeVazio(){
        Elfo master = new Elfo("");
        assertEquals("",master.getNome());
    }
    
    @Test
    public void elfoCriadoComNomeNullEPoucasFlechas(){
        Elfo mendigo = new Elfo(null,3);
        assertNull(mendigo.getNome());
        assertEquals(3,mendigo.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeNullEMuitasFlechas(){
        Elfo maurics = new Elfo(null,666);
        assertNull(maurics.getNome());
        assertEquals(666,maurics.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNoomeNullEFlechasNegativas(){
        Elfo serasa = new Elfo(null,-33);
        assertNull(serasa.getNome());
        assertEquals(-33,serasa.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomePoucasFlechas(){
        Elfo mendigo = new Elfo("mendigo",3);
        assertEquals("mendigo",mendigo.getNome());
        assertEquals(3,mendigo.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeMuitasFlechas(){
        Elfo silvio = new Elfo("silvio",300);
        assertEquals("silvio",silvio.getNome());
        assertEquals(300,silvio.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeFlechasNegativas(){
        Elfo atrasildo = new Elfo("atrasildo",-200);
        assertEquals("atrasildo",atrasildo.getNome());
        assertEquals(-200,atrasildo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo elfo = new Elfo("elfo");
        Dwarf dwarf = new Dwarf("Josias");
        int qtdFlechasEsperadas = 41;
        int experienciaEsperada = 1;
        int vidaEsperadaDoAnao = 100;
        elfo.atirarFlechaDwarf(dwarf);
        assertEquals(qtdFlechasEsperadas,elfo.getFlechas());
        assertEquals(experienciaEsperada,elfo.getXp());
        assertEquals(vidaEsperadaDoAnao,dwarf.getVida());
    }
    
    @Test
    public void doisElfosAtiramEmDoisDwarves(){
        Elfo elfo1 = new Elfo("elfo1");
        Elfo elfo2 = new Elfo("elfo2");
        Dwarf dwarf1 = new Dwarf("Josnel");
        Dwarf dwarf2 = new Dwarf("Josnelson");
        int qtdFlechasEsperadas = 40;
        int experienciaEsperada = 2;
        int vidaEsperadaDoAnao = 90;
        elfo1.atirarFlechaDwarf(dwarf1);
        elfo1.atirarFlechaDwarf(dwarf2);
        elfo2.atirarFlechaDwarf(dwarf1);
        elfo2.atirarFlechaDwarf(dwarf2);
        assertEquals(qtdFlechasEsperadas,elfo1.getFlechas());
        assertEquals(experienciaEsperada,elfo1.getXp());
        assertEquals(vidaEsperadaDoAnao,dwarf1.getVida());
        assertEquals(qtdFlechasEsperadas,elfo2.getFlechas());
        assertEquals(experienciaEsperada,elfo2.getXp());
        assertEquals(vidaEsperadaDoAnao,dwarf2.getVida());
    }
   
    @Test
    public void elfoCriadoComNomeEQuantidadeDeFlechas(){
        Elfo malandro = new Elfo("Malandro",33);
        String textoEsperado = "Malandro possui 33 flechas e 0 níveis de experiência.";
        assertEquals(textoEsperado,malandro.toString());
    }
    
    @Test
    public void elfoNasceVIVO(){
        Elfo malandrex = new Elfo("Mallandro");
        assertEquals(Status.VIVO,malandrex.getStatus());
    }
}