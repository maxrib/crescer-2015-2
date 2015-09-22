import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAno() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(1, 1, 1);
        assertEquals(1, primeiroDia.getDia());
        assertEquals(1, primeiroDia.getMes());
        assertEquals(1, primeiroDia.getAno());
    }

    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoNegativos() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(-10, -10, -10);
        assertEquals(-10, primeiroDia.getDia());
        assertEquals(-10, primeiroDia.getMes());
        assertEquals(-10, primeiroDia.getAno());
    }

    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoZerados() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(0, 0, 0);
        assertEquals(0, primeiroDia.getDia());
        assertEquals(0, primeiroDia.getMes());
        assertEquals(0, primeiroDia.getAno());
    }

    @Test
    public void ano2016EhBissexto() {
        // Arrange
        DataTerceiraEra anoQueVem = new DataTerceiraEra(01, 01, 2016);
        // Act
        boolean resultado = anoQueVem.ehBissexto();
        // Assert
        assertTrue(resultado);
    }

    @Test
    public void ano2000EhBissexto() {
        // Arrange
        DataTerceiraEra ano2000 = new DataTerceiraEra(01, 01, 2000);
        // Act
        boolean resultado = ano2000.ehBissexto();
        // Assert
        assertTrue(resultado);
    }

    @Test
    public void ano2100NaoEhBissexto() {
        // Arrange
        DataTerceiraEra ano2100 = new DataTerceiraEra(01, 01, 2100);
        // Act
        boolean resultado = ano2100.ehBissexto();
        // Assert
        assertFalse(resultado);
    }
}
