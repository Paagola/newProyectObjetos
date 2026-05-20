# 1. Configuración y uso de Maven

## Instalación sin permisos de administrador
Para usar Maven sin necesidad de tener permisos de administrador, he descargado el archivo ZIP desde la página oficial de Apache Maven.

Al tratarse de mi ordenador personal y no el del instituto, he seguido los pasos normales: he descomprimido el archivo en una carpeta de mi usuario y luego he buscado "Variables de entorno" en el menú de Windows. He editado mis variables de usuario (sin tocar las del sistema) para añadir la ruta de la carpeta `bin` de Maven a la variable `Path`.

Para comprobar que funcionaba correctamente, he abierto una terminal nueva y he escrito `mvn -version`. Al salir la versión (estoy usando la versión de Java 1.8.0_471), he comprobado que la instalación funcionaba perfectamente.

## Adaptación del proyecto
El proyecto inicial tenía todo el código fuente directamente suelto en la carpeta `src`. Para que Maven funcione bien, ya que tiene sus propias convenciones de carpetas, he creado la estructura `src/main/java/` y he movido todo mi código ahí dentro.

Además, he creado el archivo `pom.xml` en la raíz del proyecto. En este archivo he configurado:
- El `groupId` como `com.victor` y el `artifactId` como `proyecto-objetos`.
- La versión de Java a 1.8 y la codificación a UTF-8 (esto es vital porque usamos la ñ en el código del tablero y si no fallaría al compilar).
- Las dependencias de JUnit 5 para poder hacer los tests más adelante.

## Comandos utilizados
Durante este proceso y el resto de la práctica utilizaremos estos comandos de Maven:
- `mvn compile`: compila el código fuente del proyecto.
- `mvn test`: sirve para ejecutar las pruebas unitarias que configuremos con JUnit.
- `mvn javadoc:javadoc`: genera la documentación del código.
- `mvn clean`: borra la carpeta `target` para limpiar compilaciones anteriores.
