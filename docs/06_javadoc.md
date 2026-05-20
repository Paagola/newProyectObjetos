# 6. Documentación con Javadoc

Dentro de las buenas prácticas de programación en Java, es fundamental mantener el código documentado. Como parte de la práctica, hemos incluido comentarios formales en formato Javadoc a las clases principales del proyecto.

## Clases documentadas

Se han añadido comentarios `/** ... */` explicando el propósito de la clase, constructores y métodos a:
- **`Elemento.java`**: Se ha explicado que es la clase base para cualquier entidad del tablero.
- **`Personaje.java`**: Se ha documentado la herencia y los valores iniciales de vida.
- **`Malo.java`**: Se ha documentado la intención del enemigo y, además, los parámetros (`@param`) del método `atacar`.
- **`Bueno.java`**: Se ha documentado su intención de supervivencia y huida.

*(La clase `App.java` ya contaba con Javadoc en sus métodos de utilidad gracias al trabajo inicial, por lo que se han mantenido intactos para preservar el histórico del proyecto).*

## Generación de la documentación HTML

Para comprobar que los comentarios son correctos y generar la web de documentación automáticamente, usamos Maven. El comando ejecutado ha sido:

```bash
mvn javadoc:javadoc
```

Este comando recopila todos los comentarios del código fuente (en la carpeta `src/main/java`) y genera una serie de archivos HTML navegables. Los resultados se han guardado con éxito dentro de la carpeta `target/site/apidocs`.
