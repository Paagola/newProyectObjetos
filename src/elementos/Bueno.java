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


    /**
     * Detecta si un enemigo esta a menos de 10 de distancia y si lo esta huye de el.
     * Sabiendo cual es la posicion del enemeigo crea un nuevo objeto para ver cual seria la siguiente posicion mas optima para huir.
     * @param elemento
     * @param tablero
     */
    public void huir(ArrayList<Elemento> elemento, String[][] tablero) {
        
        int pasosminimos = Integer.MAX_VALUE;
        int x = 0, y = 0;

        boolean cerca = false;

        for (Elemento elem : elemento) {
            if (elem.getClass() == Malo.class) {
                int totalPasos = Math.abs(elem.getEjeY() - this.ejeY) + Math.abs(elem.getEjeX() - this.ejeX);

                if (pasosminimos > totalPasos) {
                    pasosminimos = totalPasos;
                    y = elem.getEjeY();
                    x = elem.getEjeX();

                    if (totalPasos < 10 && !cerca) {
                        cerca = true;
                    }
                }
            }
        }

        if (cerca) {
            int antiguoY = this.ejeY;
            int antiguoX = this.ejeX;

            NuevaPosicion movimiento = new NuevaPosicion(this, this.ejeY, this.ejeX, y, x, tablero);
            movimiento.moverVacio();

            tablero[antiguoY][antiguoX] = null;

            tablero[this.ejeY][this.ejeX] = this.toString();
        }
        
    }
}
