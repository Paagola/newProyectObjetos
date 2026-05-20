# 5. Análisis de Código Estático (SonarLint)

Para asegurar la calidad del código, hemos utilizado la extensión **SonarLint** integrada en Visual Studio Code. Esta herramienta analiza el código en tiempo real y detecta "code smells" (malas prácticas), vulnerabilidades y errores potenciales.

## Advertencias detectadas y solucionadas

Durante el análisis del proyecto, SonarLint nos ha avisado de varios detalles. A continuación se documentan los más relevantes y cómo se han solucionado:

### 1. "Remove this useless assignment to local variable" (Dead Store)
- **Archivo:** `App.java` (método `añadirElem`)
- **Problema:** Teníamos el siguiente código:
  ```java
  Elemento comprob = new Malo();
  switch (tipoclase) {
      case "Malo":
          comprob = new Malo();
          break;
  ...
  ```
  Estábamos instanciando un objeto `Malo` en memoria, e inmediatamente en la siguiente línea lo sobrescribíamos con un nuevo `new Malo()`, desperdiciando recursos (lo que se conoce como *Dead Store*).
- **Solución:** Hemos cambiado la inicialización a `Elemento comprob = null;`, ahorrando memoria y complaciendo las normas de rendimiento de Java.

### 2. "Standard outputs should not be used directly to log anything"
- **Archivo:** `App.java`
- **Problema:** SonarLint lanza advertencias por cada `System.out.println` o `System.out.print`, indicando que en proyectos profesionales se deben usar librerías de registro (Loggers) como *Log4j* o *SLF4J*.
- **Decisión tomada:** Al tratarse de un proyecto académico cuyo objetivo es imprimir por consola de comandos un tablero visual, hemos marcado esta regla como ignorada o justificada. Para este contexto, `System.out` es la herramienta correcta.

### 3. "Magic Numbers" y Bugs ocultos detectados
- **Archivo:** `App.java`
- **Problema:** Revisando el código a raíz de los análisis de métricas estáticas, descubrimos un bug oculto crítico en la línea donde termina el juego. En lugar de regenerar un tablero con las mismas dimensiones que el original (`new String[20][100]`), se estaba creando un array desproporcionado de `new String[20][300]`, lo cual podía ocasionar desbordamientos de memoria (`Out of Bounds`) si las coordenadas interactuaban.
- **Solución:** Se ha corregido la cifra de `300` a `100` para mantener la consistencia del tablero.

Gracias al uso del analizador, hemos mejorado no solo el estilo, sino también el rendimiento y la seguridad ante fallos de memoria en el juego.
