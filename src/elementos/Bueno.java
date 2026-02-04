package elementos;

import java.util.ArrayList;

import movimientos.NuevaPosicion;

public class Bueno extends Personaje{

    public Bueno() {
        this.ejeX = ejeX();
        this.ejeY = ejeY();
        this.vida = vida();
    }

    @Override
    public String toString() {
        return GREEN + "ï" + RESET;
    }

    public void huir(ArrayList<Elemento> elemento, String[][] tablero) {
        
        int pasosminimos = Integer.MAX_VALUE;
        int x = 0, y = 0;

        for (Elemento elem : elemento) {
            if (elem.getClass() == Malo.class) {
                int totalPasos = Math.abs(elem.getEjeY() - this.ejeY) + Math.abs(elem.getEjeX() - this.ejeX);

                if (pasosminimos > totalPasos) {
                    pasosminimos = totalPasos;
                    y = elem.getEjeY();
                    x = elem.getEjeX();
                }
            }
        }
        int antiguoY = this.ejeY;
        int antiguoX = this.ejeX;

        NuevaPosicion movimiento = new NuevaPosicion(this.ejeY, this.ejeX, y, x, tablero);
        movimiento.moverVacioBueno();

        tablero[antiguoY][antiguoX] = null;

        this.ejeX = movimiento.getEjeX();
        this.ejeY = movimiento.getEjeY();

        tablero[this.ejeY][this.ejeX] = this.toString();
    }



}
