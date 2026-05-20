# 4. Pruebas Unitarias

Para asegurar que las mecánicas básicas del juego funcionan correctamente después de la refactorización, hemos implementado pruebas unitarias utilizando **JUnit 5**.

Siguiendo la convención de Maven, hemos creado la carpeta `src/test/java/` y dentro hemos replicado el paquete `elementos`.

## Pruebas implementadas

Hemos creado dos clases de prueba sencillas y directas para verificar la integridad del código:

### 1. `ElementoTest.java`
Esta clase comprueba que la generación aleatoria de coordenadas dentro del tablero sea correcta:
- **`testCoordenadasDentroDelTablero`**: Al crear cualquier nuevo elemento, verifica mediante `assertTrue` que la coordenada X generada nunca se sale de los límites horizontales (0-99) y que la coordenada Y no se sale de los verticales (0-19).

### 2. `PersonajeTest.java`
Esta clase comprueba el estado básico de los personajes:
- **`testVidaInicial`**: Verifica mediante `assertEquals` que la regla de juego principal se cumple y la vida por defecto de todo personaje al nacer es exactamente 50.
- **`testModificarVida`**: Modifica la vida de un personaje con `setVida()` (simulando daño o curación) y comprueba que se guarda correctamente en el objeto.

*(Nota de diseño: Se ha decidido no probar la lógica de `atacar()` porque esta depende en gran medida de resultados aleatorios (`Math.random()`), lo cual provocaría que los tests pasaran unas veces y otras no ("flaky tests"), lo que es una mala práctica en testing unitario).*

## Ejecución de las pruebas
Para lanzar estas pruebas en cualquier ordenador, basta con abrir la terminal y escribir el comando:
```bash
mvn test
```
Maven se encargará de compilar los tests y nos mostrará un informe verde indicando si todas las comprobaciones han sido un éxito.
