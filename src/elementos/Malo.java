package elementos;

import java.util.ArrayList;

import movimientos.NuevaPosicion;

public class Malo extends Personaje {

    public Malo() {
        this.ejeX = ejeX();
        this.ejeY = ejeY();
        this.vida = vida();
    }

    @Override
    public String toString() {
        return RED + "Ö" + RESET;
    }

    /**
     * Detecta cual es el bueno mas cercano a el y crea un objeto para saber cual
     * seria el siguiente movimiento mas inteligente.
     * 
     * @param elemento
     * @param tablero
     */
    public void cazar(ArrayList<Elemento> elemento, String[][] tablero) {

        int pasosminimos = Integer.MAX_VALUE;
        int x = 0, y = 0;

        for (Elemento elem : elemento) {
            if (elem.getClass() == Bueno.class) {
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

        NuevaPosicion movimiento = new NuevaPosicion(this, this.ejeY, this.ejeX, y, x, tablero);
        movimiento.moverVacio();

        tablero[antiguoY][antiguoX] = null;

        tablero[this.ejeY][this.ejeX] = this.toString();
    }

    public void atacar(Elemento elemMalo, Elemento elemBueno) {

        int eleccion = (int) (Math.random() * 10) + 1;

        switch (eleccion) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                Bueno b1 = (Bueno) elemBueno;
                b1.setVida(b1.getVida() - 3);
                break;

            case 10:
                this.vida -= 5;
                break;
            default:

                break;
        }
    }
}
