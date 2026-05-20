package elementos;

/**
 * Clase base que representa un elemento físico en el tablero del juego.
 * Cualquier entidad con coordenadas (X, Y) hereda de esta clase.
 */
public class Elemento {
    protected int ejeX;
    protected int ejeY;

    /**
     * Constructor por defecto.
     * Inicializa las coordenadas de aparición de forma aleatoria 
     * dentro de los límites del tablero (100x20).
     */
    public Elemento() {
        this.ejeY = (int)(Math.random()*20);
        this.ejeX = (int)(Math.random()*100);
    }

    //Getters y Setters
    public int getEjeX() {
        return this.ejeX;
    }

    public int getEjeY() {
        return this.ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }
}