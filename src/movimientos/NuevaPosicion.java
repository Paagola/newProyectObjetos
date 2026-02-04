package movimientos;

import java.util.ArrayList;

import elementos.Elemento;
import elementos.Personaje;
import elementos.Piedra;

public class NuevaPosicion extends Personaje {
    protected int nuevaX;
    protected int nuevaY;
    protected int ejeX;
    protected int ejeY;
    protected String[][] tablero;

    public NuevaPosicion(int ejeY, int ejeX, int nuevaY, int nuevaX, String[][] tablero) {
        this.nuevaY = nuevaY;
        this.nuevaX = nuevaX;
        this.ejeY = ejeY;
        this.ejeX = ejeX;
        this.tablero = tablero;
    }

    @Override
    public int getEjeX() {
        return this.ejeX;
    }

    @Override
    public int getEjeY() {
        return this.ejeY;
    }

    /**
     * 
     */
    public void moverVacioBueno() {

        boolean movimiento = false;

        if (this.nuevaY > this.ejeY && buscarVacio(this.ejeY - 1, this.ejeX)) {
            this.ejeY -= 1;
            movimiento = true;
        } else if (this.nuevaY < this.ejeY && buscarVacio(this.ejeY + 1, this.ejeX)) {
            this.ejeY += 1;
            movimiento = true;
        }

        if (this.nuevaX > this.ejeX && buscarVacio(this.ejeY, this.ejeX - 1)) {
            this.ejeX -= 1;
            movimiento = true;
        } else if (this.nuevaX < this.ejeX && buscarVacio(this.ejeY, this.ejeX + 1)) {
            this.ejeX += 1;
            movimiento = true;
        }
        nuncaQuedarseQuieto(movimiento);
    }

    public void moverVacioMalo() {

        if (this.nuevaY > this.ejeY && buscarVacio(this.ejeY + 1, this.ejeX)) {
            this.ejeY += 1;
        } else if (this.nuevaY < this.ejeY && buscarVacio(this.ejeY - 1, this.ejeX)) {
            this.ejeY -= 1;
        }
        
        if (this.nuevaX > this.ejeX && buscarVacio(this.ejeY, this.ejeX + 1)) {
            this.ejeX += 1;
        } else if (this.nuevaX < this.ejeX && buscarVacio(this.ejeY, this.ejeX - 1)) {
            this.ejeX -= 1;
        }
    }

    public boolean buscarVacio(int y, int x) {

        if (y > tablero.length - 1 || y < 0) {
            return false;
        } else if (x > tablero[0].length - 1 || x < 0) {
            return false;
        } else if (this.tablero[y][x] == null) {
            return true;
        }
        return false;
    }

    /**
     * Si no se ha hecho ningun movimiento intentamos que busque una salida para 
     * que no se quede nunca quieto
     * @param estado
     */
    public void nuncaQuedarseQuieto(boolean estado) {
        if (!estado) {
            if (buscarVacio(this.ejeY - 1, this.ejeX)) {
                this.ejeY -= 1;
            } else if (buscarVacio(this.ejeY + 1, this.ejeX)) {
                this.ejeY += 1;
            } else if (buscarVacio(this.ejeY, this.ejeX - 1)) {
                this.ejeX -= 1;
            } else if (buscarVacio(this.ejeY, this.ejeX + 1)) { 
                this.ejeX += 1;
            }
        }
    }

}
