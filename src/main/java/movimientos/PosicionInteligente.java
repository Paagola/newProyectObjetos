package movimientos;

import elementos.Malo;
import elementos.Personaje;

public class PosicionInteligente extends NuevaPosicion{

    private static int[] direccionY = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    private static int[] direccionX = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public PosicionInteligente(Personaje personaje, int ejeY, int ejeX, int nuevaY, int nuevaX, String[][] tablero) {
        super(personaje, ejeY, ejeX, nuevaY, nuevaX, tablero);
    }

    /**
     * En base a un array de booleanos diciendo cuales son las posiciones que puede acceder calcular cual es la mas optima para huir.
     * @param array
     */
    public void moverSegunArray(boolean[] array) {
        double pasosminimos = ((personaje.getClass() == Malo.class)? Double.MAX_VALUE: Double.NEGATIVE_INFINITY);
        
        int y = 0, x = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                double totalPasos = (Math.abs((direccionY[i] + this.ejeY) - this.nuevaY))
                                    + (Math.abs((direccionX[i] + this.ejeX) - this.nuevaX));

                if (((this.personaje.getClass() == Malo.class)? totalPasos < pasosminimos: totalPasos > pasosminimos) ) {
                    pasosminimos = totalPasos;
                    y = direccionY[i];
                    x = direccionX[i];
                }
            }
        }

        personaje.setEjeX(personaje.getEjeX() + (x));
        personaje.setEjeY(personaje.getEjeY() + (y));
    }

}
