import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void criarItemComQuantidadeDescricaoInformadas() {
        // Arrange
        int quantidadeEsperada = 12;
        String descricaoEsperada = "Martelo de Thor - Mjollnir";
        // Act
        Item item = new Item(quantidadeEsperada, descricaoEsperada);
        // Assert
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
    
    @Test
    public void criarItemComQuantidadeNegativaDescricaoNula() {
        // Arrange
        int quantidadeEsperada = -3456;
        String descricaoEsperada = null;
        // Act
        Item item = new Item(quantidadeEsperada, descricaoEsperada);
        // Assert
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
    
    @Test
    public void aumentar1000Unidades() {
        Item espada = new Item(42, "Espada");
        espada.aumentar1000Unidades();
        assertEquals(1042, espada.getQuantidade());
    }
    
    @Test
    public void aumentarQuantidadesComSomatorio() {
        Item espada = new Item(5, "Espada");
        espada.aumentarQuantidadesComSomatorio();
        
        assertEquals(15005, espada.getQuantidade());
    }
    
    @Test
    public void debitarUmaUnidadeDoItem(){
        Item flechas = new Item(3, "Flecha");
        flechas.debitarUmaUnidade();
        
        assertEquals(2, flechas.getQuantidade());
    }
}
