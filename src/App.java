import java.io.IOException;
import java.util.ArrayList;

import elementos.*;

public class App {
    public static void main(String[] args) throws Exception {

        boolean salir = false;
        String[][] tablero = new String[20][100];
        ArrayList<Elemento> elementos = new ArrayList<>();
        elementos = añadirElem(elementos, 20, "Bueno");
        elementos = añadirElem(elementos, 10, "Malo");
        elementos = añadirElem(elementos, 30, "Piedra");

        do {

            int contadorMalos = 0;
            int contadorBueno = 0;

            tablero = new String[20][100];
            peleaEntreBuenoYMalo(elementos);
            eliminarSinVida(elementos);
            tablero = añadirElemTablero(tablero, elementos);
            pintarTablero(tablero);
            elementos = cazarHuir(elementos, tablero);
            

            for (Elemento e : elementos) {
                if (e.getClass() == Malo.class) {
                    contadorMalos++;
                } else if (e.getClass() == Bueno.class) {
                    contadorBueno++;
                }
            }

            if (contadorBueno != 0 && contadorMalos !=0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } clearScreen();
            } else {
                salir = true;
                clearScreen();
                tablero = new String[20][100];
                peleaEntreBuenoYMalo(elementos);
                eliminarSinVida(elementos);
                tablero = añadirElemTablero(tablero, elementos);
                pintarTablero(tablero);
            }

            

        } while (!salir);

    }

    /**
     * Limpiar la pantalla sin problemas (hecho con IA)
     */
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Fallback: imprimir líneas en blanco
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }

    /**
     * Pinta el tablero con todos los elementos dentro.
     * 
     * @param tablero
     */
    public static void pintarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(tablero[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static ArrayList<Elemento> eliminarSinVida(ArrayList<Elemento> elementos) {
        
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getClass() != Piedra.class) {
                Personaje p1 = (Personaje) elementos.get(i);
                if (p1.getVida() < 1) {
                    elementos.remove(i);
                }
            }
        }
        return elementos;
    }

    /**
     * Añade los elementos al tablero con su respectivo simbolo
     * 
     * @param tablero
     * @param elementos
     * @return
     */
    public static String[][] añadirElemTablero(String[][] tablero, ArrayList<Elemento> elementos) {
        for (Elemento elemento : elementos) {
                tablero[elemento.getEjeY()][elemento.getEjeX()] = elemento.toString();
        }
        return tablero;
    }

    /**
     * Añade elementos del tipo que se pida al ArrayList.
     * 
     * @param elementos
     * @param numMalos
     * @param tipoclase
     * @return
     */
    public static ArrayList<Elemento> añadirElem(ArrayList<Elemento> elementos, int numMalos, String tipoclase) {
        for (int i = 0; i < numMalos; i++) {
            Elemento comprob = new Malo();
            switch (tipoclase) {
                case "Malo":
                    comprob = new Malo();
                    break;

                case "Bueno":
                    comprob = new Bueno();
                    break;

                case "Piedra":
                    comprob = new Piedra();
                    break;

                default:
                    break;
            }

            int y = comprob.getEjeY();
            int x = comprob.getEjeX();

            while (comprobarOcupado(elementos, y, x) || malosYbuenosLejos(elementos, tipoclase, y, x)) {
                comprob.setEjeY(comprob.ejeY());
                comprob.setEjeX(comprob.ejeX());
                y = comprob.getEjeY();
                x = comprob.getEjeX();
            }
            elementos.add(comprob);
        }
        return elementos;
    }

    /**
     * Comprueba si un objeto ya tiene esas posiciones x e y para no superponerse.
     * 
     * @param elementos
     * @param y
     * @param x
     * @return
     */
    public static boolean comprobarOcupado(ArrayList<Elemento> elementos, int y, int x) {
        for (Elemento elemento : elementos) {
            if (elemento.getEjeY() == y && elemento.getEjeX() == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Revisa si un bueno y un malo tienen 5 espacios tanto de ancho como de alto al
     * empezar el juego.
     * 
     * @param elementos
     * @param tipoClase
     * @param y
     * @param x
     * @return
     */
    public static boolean malosYbuenosLejos(ArrayList<Elemento> elementos, String tipoClase, int y, int x) {

        if (tipoClase.equals("Piedra")) {
            return false;
        } else if (tipoClase.equals("Malo")) {
            for (Elemento elemento : elementos) {
                if (((Math.abs(elemento.getEjeY() - y) < 5) &&
                        (Math.abs(elemento.getEjeX() - x) < 5)) && elemento.getClass() == Bueno.class) {
                    return true;
                }
            }
        } else if (tipoClase.equals("Bueno")) {
            for (Elemento elemento : elementos) {
                if (((Math.abs(elemento.getEjeY() - y) < 5) &&
                        (Math.abs(elemento.getEjeX() - x) < 5)) && elemento.getClass() == Malo.class) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<Elemento> cazarHuir(ArrayList<Elemento> elementos, String[][] tablero) {

        for (Elemento elem : elementos) {
            if (elem.getClass() == Malo.class) {
                Malo m1 = (Malo) elem;
                m1.cazar(elementos, tablero);
            } else if (elem.getClass() == Bueno.class) {
                Bueno b1 = (Bueno) elem;
                b1.huir(elementos, tablero);
            }
        }
        return elementos;
    }

    public static void peleaEntreBuenoYMalo(ArrayList<Elemento> elementos) {
        for (Elemento elem : elementos) {
            if (elem.getClass() == Malo.class) {
                for (Elemento elemtwo : elementos) {
                    if (elemtwo.getClass() == Bueno.class) {

                        if (Math.abs(elem.getEjeX() - elemtwo.getEjeX()) <= 1
                                && Math.abs(elem.getEjeY() - elemtwo.getEjeY()) <= 1) {
                                    Malo m1 = (Malo) elem;
                                    m1.atacar(elem, elemtwo);
                        }
                    }
                }
            }
        }
    }
}
