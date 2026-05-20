package elementos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementoTest {

    @Test
    public void testCoordenadasDentroDelTablero() {
        Elemento e = new Elemento();
        
        // El eje X debe estar entre 0 y 99
        assertTrue(e.getEjeX() >= 0 && e.getEjeX() < 100, "La coordenada X debe generarse entre 0 y 99");
        
        // El eje Y debe estar entre 0 y 19
        assertTrue(e.getEjeY() >= 0 && e.getEjeY() < 20, "La coordenada Y debe generarse entre 0 y 19");
    }
}
