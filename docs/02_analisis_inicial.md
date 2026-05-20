# 2. Análisis inicial del proyecto

Antes de empezar a modificar el código, he revisado a fondo cómo está estructurado el juego en su versión por consola. He encontrado varias cosas que podemos mejorar para que el código sea más profesional, legible y cumpla con los principios de Programación Orientada a Objetos.

## Clases principales y responsabilidades
- `App`: Es la clase principal. Actualmente tiene demasiada responsabilidad (controla el bucle del juego, crea los personajes, comprueba colisiones, pinta el tablero...).
- `Elemento` y `Personaje`: Son las clases base de las que heredan los personajes. `Personaje` añade vida y velocidad.
- `Bueno`, `Malo` y `Piedra`: Son los elementos concretos del juego.
- `NuevaPosicion` y `PosicionInteligente`: Se encargan de calcular hacia dónde se deben mover los personajes.

## Problemas detectados a refactorizar

1. **La clase `App` es un "God Object" (hace de todo):**
   - Se encarga de gestionar el Array de elementos, pintar el tablero, manejar las peleas y limpiar la consola. Toda esta lógica está aglomerada.
   - *Mejora:* Deberíamos extraer métodos o incluso crear una clase `GestorTablero` para no tener un archivo tan grande.

2. **Mal uso de la Herencia:**
   - La clase `NuevaPosicion` hereda de `Personaje` (`public class NuevaPosicion extends Personaje`). Esto es un error conceptual porque una coordenada o lógica de movimiento **no es** un Personaje.
   - *Mejora:* Eliminar esa herencia y usar los objetos por parámetro.

3. **Código duplicado y redundante:**
   - En la clase `Malo`, el método `atacar()` tiene un `switch` donde los casos del 1 al 9 hacen exactamente lo mismo (quitar 3 puntos de vida al Bueno). 
   - *Mejora:* Se puede simplificar a un simple `if (eleccion <= 9)`.

4. **Creación de valores aleatorios fuera de los constructores:**
   - En vez de inicializar los ejes en los constructores clásicos, hay métodos como `public int ejeX()` en `Elemento` o `public static int vida()` en `Personaje` que generan valores sueltos. 
   - *Mejora:* Todo esto se debería inicializar limpiamente en el constructor de cada clase.

5. **Nombres de variables y falta de encapsulamiento:**
   - Se están usando arrays de booleanos y listas sin una estructura muy clara. Algunos atributos son `protected` y se accede a ellos directamente en vez de forzar el uso de *Getters* y *Setters*.

Con todo este análisis, ya tenemos claro qué cosas debemos arreglar en la fase de refactorización para subirle la nota técnica al proyecto.
