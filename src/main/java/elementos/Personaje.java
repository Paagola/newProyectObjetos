package elementos;

/**
 * Representa una entidad viva dentro de la simulación.
 * Añade atributos de estado como la vida y la velocidad al Elemento base.
 */
public class Personaje extends Elemento{

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";


    protected int vida;
    protected int velocidad;

    /**
     * Constructor que asigna las estadísticas iniciales del personaje.
     * La vida por defecto es 50.
     */
    public Personaje() {
        super();
        this.vida = 50;
        this.velocidad = (int)(Math.random()*2) + 1;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
