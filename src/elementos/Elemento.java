package elementos;

public class Elemento {
    protected int ejeX;
    protected int ejeY;

    public int ejeY() {
        return (int)(Math.random()*20);
    }

    public int ejeX() {
        return (int)(Math.random()*100);
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