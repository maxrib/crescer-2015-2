

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste SnagaTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class SnagaTest
{
    @Test
    public void criaSnaga(){
        Orc orc = new Snaga();
        
        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item(1, "Arco"));
        inventarioEsperado.adicionarItem(new Item(5, "Flecha"));
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(inventarioEsperado, orc.getInventario());
    }
    
    @Test
    public void orcSnagaRecebeDano(){
        Orc orc = new Snaga();
        
        orc.levarAtaque();
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        for(int i = 0; i < 6; i++){
            orc.atacar(elfo);
        }
        
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){
    
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        orc.atacar(elfo);
        
        int qtdFlechas = orc.getInventario().getItemPorDescricao("Flecha").getQuantidade();
        
        assertEquals(4, qtdFlechas);
        
    }
    
    @Test
    public void orcSnagaRecebe6DeDanoPorqueGanhouUmEscudo(){
        Orc orc = new Snaga();
        
        orc.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        
        orc.levarAtaque();
        
        assertEquals(64, orc.getVida());
    }
    
    @Test
    public void orcSnagaCausa8DeDanoEmElfoPorqueAtacouComArco(){
        Orc orc = new Snaga();
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 72;
        
        orc.atacar(legolas);
        
        assertEquals(vidaEsperada, legolas.getVida());
    }
    
    @Test
    public void orcSnagaCausa12DeDanoEmElfoPorqueGanhouUmaEspadaEAtacou(){
        Orc orc = new Snaga();
        orc.adicionarItem(new Item(1, "Espada"));
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 68;
        
        orc.atacar(legolas);
        
        assertEquals(vidaEsperada, legolas.getVida());
    }
    
    @Test
    public void orcSnagaFogePorqueNaoTemArmaParaAtacar(){
        Orc orc = new Snaga();
        orc.perderItem(new Item(1, "Arco"));
        orc.perderItem(new Item(5, "Flecha"));
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 80;
        
        orc.atacar(legolas);
        
        assertEquals(Status.FUGINDO, orc.getStatus());
        assertEquals(vidaEsperada, legolas.getVida());
    }
    
    @Test
    public void orcSnagaRecebeAtaqueDeUrukHai(){
        Orc snaga = new Snaga();
        Orc urukHai = new UrukHai();
        
        snaga.receberAtaqueDoOrc(urukHai);
        
        assertEquals(60, snaga.getVida());
    }
    
    @Test
    public void orcSnagaRecebeAtaqueDeSnaga(){
        Orc snagaAlvo = new Snaga();
        Orc snagaAtacante = new Snaga();
        
        snagaAlvo.receberAtaqueDoOrc(snagaAtacante);
        
        assertEquals(60, snagaAlvo.getVida());
    }
    
}
