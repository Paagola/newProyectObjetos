# 3. Refactorización del código

Una vez analizado el código inicial, he procedido a realizar una serie de refactorizaciones sencillas pero muy eficaces para mejorar la calidad del código, haciéndolo más limpio y respetando mejor las normas de la Programación Orientada a Objetos (POO).

## Cambios realizados

### 1. Limpieza de constructores
Antes, las clases dependían de métodos sueltos (como `ejeX()` o `vida()`) que generaban valores aleatorios. Esto era un mal diseño porque dejaba parte de la inicialización de los objetos fuera de los constructores.
He creado constructores formales en `Elemento.java` y `Personaje.java`. De esta forma, al instanciar un `Malo` o un `Bueno`, simplemente se llama a `super()` y la superclase se encarga internamente de asignar su vida y coordenadas de inicio.

### 2. Corrección de herencia en `NuevaPosicion`
La clase `NuevaPosicion.java` tenía un error conceptual importante: heredaba de `Personaje` (`extends Personaje`). En POO, la herencia significa "es un" (ejemplo: un Malo *es un* Personaje). Sin embargo, una posición o cálculo de movimiento no es un personaje.
Para arreglarlo, he eliminado la herencia (`extends Personaje`). Ahora funciona mejor usando *composición*, guardando el `Personaje` que se le pasa por el constructor como una variable interna.

### 3. Simplificación de condicionales en `Malo.java`
En la clase `Malo`, el método `atacar` utilizaba un bloque `switch` con los casos del 1 al 9 completamente repetidos y vacíos, terminando todos en la misma acción.
Lo he refactorizado cambiándolo por un simple condicional `if (eleccion <= 9)`. Esto nos ahorra muchas líneas de código y hace que su lectura sea inmediata.

### 4. Desacoplamiento en la clase principal
En `App.java`, en el momento de generar las posiciones para evitar que los personajes se pisen, se dependía de los métodos internos que acabamos de borrar. Se han reemplazado por cálculos directos usando `Math.random()`, limpiando el código y eliminando esa dependencia de diseño.

## Verificación
Tras aplicar estos cambios, he vuelto a compilar el proyecto asegurándome de que todo el comportamiento del juego sigue intacto. El código base ahora es mucho más seguro para empezar a escribir las pruebas unitarias.
