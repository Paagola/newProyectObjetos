package movimientos;

import elementos.Personaje;


public class NuevaPosicion extends Personaje {
    protected int nuevaX;
    protected int nuevaY;
    protected Personaje personaje;
    protected String[][] tablero;
    protected int ejeY;
    protected int ejeX;


    public NuevaPosicion(Personaje personaje, int ejeY, int ejeX, int nuevaY, int nuevaX, String[][] tablero) {
        this.nuevaY = nuevaY;
        this.nuevaX = nuevaX;
        this.tablero = tablero;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.personaje = personaje;
    }

    /**
     * Crea una array de booleanos diciendo desde arriba a la izquierda hasta abajo a la derecha cuales son las posiciones que puede ocupar.e
     */
    public void moverVacio() {
        boolean[] posic = new boolean[9];
        int indx = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (buscarVacio(this.ejeY + (i), this.ejeX + (j) )) {
                    posic[indx] = true;
                } else {
                    posic[indx] = false;
                }
                indx++;
            }
        }
        PosicionInteligente posIn = new PosicionInteligente(this.personaje, this.ejeY, this.ejeX, this.nuevaY, this.nuevaX, tablero);
        posIn.moverSegunArray(posic);
    }

    /**
     * Verifica que la x y la y a la que se quiere acceder no se salgan del tablero y no esten ocupadas.
     * @param y
     * @param x
     * @return
     */
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
}