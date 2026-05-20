# 7. Integración Continua con GitHub Actions

Para automatizar el proceso de compilación y pruebas, hemos configurado una acción de integración continua utilizando **GitHub Actions**.

## ¿Qué es la integración continua?

La integración continua consiste en ejecutar automáticamente una serie de comprobaciones (compilar, testear...) cada vez que alguien sube código al repositorio. El objetivo es detectar errores lo antes posible, antes de que lleguen a la rama principal del proyecto.

## ¿Cuándo se ejecuta nuestra acción?

Hemos configurado la acción para que se lance en dos situaciones:
- Cuando se hace un **push** a la rama `mejora-tecnica`.
- Cuando se abre una **pull request** hacia la rama `main`.

## ¿Qué hace exactamente?

El fichero `.github/workflows/maven.yml` define los pasos que se ejecutan en un servidor de Ubuntu limpio:

1. **Descargar el código:** Se descarga todo el repositorio en el servidor de GitHub.
2. **Configurar Java 8:** Se instala la versión de Java que utiliza nuestro proyecto para que la compilación sea consistente con nuestro entorno local.
3. **Compilar:** Se ejecuta `mvn compile` para verificar que no hay errores de compilación.
4. **Testear:** Se ejecuta `mvn test` para lanzar automáticamente todas las pruebas unitarias que hemos escrito con JUnit 5.

Si cualquiera de esos pasos falla, GitHub marca el push con una cruz roja y avisa al equipo. Si todo va bien, aparece una marca verde.

## Relación con las pruebas unitarias

Esta acción y las pruebas del Paso 4 están directamente relacionadas. Las pruebas escritas en `ElementoTest.java` y `PersonajeTest.java` son las que GitHub Actions ejecutará automáticamente con `mvn test`. Esto garantiza que cualquier cambio futuro que rompa la lógica del juego sea detectado de forma automática sin que nadie tenga que recordar lanzar los tests manualmente.
