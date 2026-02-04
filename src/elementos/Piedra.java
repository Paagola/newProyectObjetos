package elementos;

public class Piedra extends Elemento{

    public Piedra() {
        this.ejeX = ejeX();
        this.ejeY = ejeY(); 
    }

    @Override
    public String toString() {
        return "■";
    }
}
