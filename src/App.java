import java.io.IOException;
import java.util.ArrayList;

import elementos.*;

public class App {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) throws Exception {

        boolean salir = false;
        ArrayList<Elemento> elementos = new ArrayList<>();
        elementos = añadirElem(elementos, 25, "Bueno");
        elementos = añadirElem(elementos, 6, "Malo");
        elementos = añadirElem(elementos, 100, "Piedra");

        do {

            int contadorMalos = 0;
            int contadorBueno = 0;
            clearScreen();
            String[][] tablero = new String[20][100];
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } 
            } else {
                salir = true;
                clearScreen();
                tablero = new String[20][100];
                peleaEntreBuenoYMalo(elementos);
                eliminarSinVida(elementos);
                tablero = añadirElemTablero(tablero, elementos);
                pintarTablero(tablero);

                System.out.println("\n\t\t\t\tLos " + ((contadorBueno == 0)? RED + "Malos" + RESET: 
                                                            GREEN + "Buenos" + RESET) + " han ganado\n");
            }
        } while (!salir);

    }

    /**
     * Limpiar la pantalla sin problemas 
     */
    public static void clearScreen() {
        System.out.print("\033[H"); 
        System.out.flush();
    }

    /**
     * Pinta el tablero con todos los elementos dentro.
     * 
     * @param tablero
     */
    public static void pintarTablero(String[][] tablero) {

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == null) {
                    buffer.append(" ");
                } else {
                    buffer.append(tablero[i][j]);
                }
            }
            buffer.append("\n");
        }
        System.out.print(buffer.toString());
    }

    /**
     * Verifica que todos los elementos tengan vida y si su vida es 0 o menor los elimina del array.
     * @param elementos
     * @return
     */
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


    /**
     * Recorre el array principal de elementos y segun su categoria le asigna su funcion de cazar o huir
     * @param elementos
     * @param tablero
     * @return
     */
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

    /**
     * Verifica si un malo esta cerca de un bueno y si lo esta ejecuta su funcion de atacar.
     * @param elementos
     */
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
