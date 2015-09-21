import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class InventarioTest
{
    @Test
    public void adicionarItemNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Adaga"));

        mochila.adicionarItem(new Item(1, "Adaga"));

        assertEquals(esperado, mochila);
    }

    @Test
    public void adicionarDoisItensNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(2, "Poções"));
        esperado.adicionarItem(new Item(1, "Machado"));

        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemDoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        Item adaga = new Item(1, "Adaga");
        mochila.adicionarItem(adaga);

        mochila.perderItem(adaga);

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemComDoisNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        Item adaga = new Item(1, "Adaga");
        Item escudo = new Item(2, "Escudo");
        esperado.adicionarItem(escudo);
        mochila.adicionarItem(adaga);
        mochila.adicionarItem(escudo);

        mochila.perderItem(adaga);

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemQueNãoEstáNoInventário() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        mochila.perderItem(new Item(1, "Luvas de prata"));
        assertEquals(esperado, mochila);
    }

    @Test
    public void getDescricoesItensComDoisItens() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));
        String esperado = "Poções,Machado";
        String obtido = mochila.getDescricoesItens();
        assertEquals(esperado, obtido);
    }

    @Test
    public void aumentar1000UnidadesEmCadaItem() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1002, "Poções"));
        esperado.adicionarItem(new Item(1001, "Machado"));
        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));
        mochila.aumentar1000UnidadesEmCadaItem();
        
        assertEquals(esperado, mochila);
    }
    
    @Test
    public void obterItemComMaiorQuantidade() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(9, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(2, "Canivete suíço"));
        Item esperado = new Item(99, "Escudo");
        Item obtido = mochila.getItemComMaiorQuantidade();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void obterItemComMaiorQuantidadeTodosIguais() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(99, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(99, "Canivete suíço"));
        Item esperado = new Item(99, "Elder Scroll");
        Item obtido = mochila.getItemComMaiorQuantidade();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void ordenarItens() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(9, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(2, "Canivete suíço"));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(2, "Canivete suíço"));
        esperado.adicionarItem(new Item(9, "Elder Scroll"));
        esperado.adicionarItem(new Item(99, "Escudo"));
        
        mochila.ordenarItens();
        
        assertEquals(esperado, mochila);
    }

}
