package elementos;

public class Personaje extends Elemento{

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    protected int vida;
    protected int velocidad;

    public static int vida() {
        return (int)(Math.random()*10) + 5;
    }

    public static int velocidad() {
        return (int)(Math.random()*2) + 1;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
