package elementos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void testVidaInicial() {
        Personaje p = new Personaje();
        
        // Todos los personajes deben empezar con 50 puntos de vida
        assertEquals(50, p.getVida(), "La vida inicial del personaje debería ser exactamente 50");
    }

    @Test
    public void testModificarVida() {
        Personaje p = new Personaje();
        
        // Simulamos que recibe un ataque
        p.setVida(30);
        
        assertEquals(30, p.getVida(), "La vida del personaje debería haberse actualizado a 30");
    }
}
