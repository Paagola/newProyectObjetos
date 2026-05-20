# Plan de Trabajo y Guía de Ejecución

Este documento sirve como hoja de ruta central para organizar y ejecutar la práctica de mejora técnica, documentación y modelado UML. Está diseñado para ser leído tanto por el desarrollador humano (el usuario) como por la Inteligencia Artificial (IA) que asiste en el proyecto.

---

## 👤 Instrucciones para el Usuario (Desarrollador)

Para conseguir la nota máxima y que el proyecto cumpla todos los requisitos técnicos indicados en el `context.md`, debes seguir un proceso ordenado. Tu rol principal será tomar las decisiones de diseño, configurar tu entorno local y guiar a la IA paso a paso.

### Preparación del Entorno (¡Haz esto primero!)
1. **Crear una nueva rama en Git:**
   - La práctica prohíbe trabajar directamente en `main`.
   - Abre tu terminal en el proyecto y ejecuta: `git checkout -b mejora-tecnica` (o el nombre que prefieras).
2. **Instalar Maven (si no lo tienes):**
   - Asegúrate de poder ejecutar `mvn -version` en tu terminal.
   - Si no tienes permisos de administrador: descarga el archivo ZIP de Maven desde su web, descomprímelo en una carpeta de tu usuario y añade la ruta de su carpeta `bin` a las variables de entorno de tu cuenta de Windows (`Path`).
3. **Instalar Extensiones en VS Code:**
   - Instala **"Extension Pack for Java"** (si no lo tienes ya).
   - Instala un analizador estático compatible con VS Code. Te recomendamos **"SonarLint"**.

### ¿Cómo interactuar con la IA a partir de ahora?
Ve pidiéndole a la IA que aborde los pasos **uno por uno**. Evita pedirle que haga todo a la vez para no perder el control del código.
Ejemplo de prompt para la IA:
> *"IA, vamos a empezar con el Paso 1 detallado en `docs/00_PLAN_DE_TRABAJO.md`. Por favor, ayúdame a adaptar el proyecto a Maven y crea el documento 01_maven.md."*

---

## 🤖 Instrucciones para la IA (System / Context Prompt)

**Atención IA:** Cuando el usuario te pida continuar con el proyecto o consultar este archivo, tu objetivo será asistirle en la refactorización, configuración y documentación cumpliendo estrictamente con los requisitos del archivo `context.md`.

**Reglas Críticas para la IA:**
1. **No inventar un juego nuevo:** El objetivo es *mejorar, documentar y refactorizar*, NO cambiar la esencia de la aplicación ni añadir nuevas funcionalidades (gráficos, menús, etc.).
2. **Todo debe documentarse en Markdown:** Por cada paso técnico finalizado, debes crear o actualizar el correspondiente archivo `.md` en esta misma carpeta `docs/`.
3. **Paso a Paso:** Ejecuta solo el paso que te pida el usuario. 

### Los 9 Pasos del Proyecto:

#### Paso 1: Adaptación a Maven (`docs/01_maven.md`)
- **Acción:** Ayudar al usuario a crear un `pom.xml`. Adaptar la estructura del proyecto (la convención estándar de Maven exige mover el código de `src/` a `src/main/java/`). Configurar `maven-compiler-plugin` usando Java 8/11/17 (según lo que use el usuario) y codificación `UTF-8` obligatoria.
- **Documentación:** Redactar en `01_maven.md` los comandos usados y el proceso de migración para evidenciar el aprendizaje.

#### Paso 2: Análisis Inicial (`docs/02_analisis_inicial.md`)
- **Acción:** Leer los archivos actuales (`App.java`, `Malo.java`, `Bueno.java`, etc.).
- **Identificar:** Detectar código duplicado, métodos demasiado largos (como en `App.java`), falta de encapsulación de atributos, nombres mejorables, etc.
- **Documentación:** Redactar el análisis en Markdown de forma detallada antes de cambiar el código.

#### Paso 3: Refactorización (`docs/03_refactorizacion.md`)
- **Acción:** Ejecutar las mejoras detectadas en el Paso 2. Renombrar variables, extraer métodos, simplificar la clase principal y encapsular atributos.
- **Documentación:** Explicar qué problema se detectó y cómo se solucionó (puedes usar fragmentos de código del "antes" y el "después").

#### Paso 4: Pruebas Unitarias (`docs/04_pruebas_unitarias.md`)
- **Acción:** Añadir la dependencia de **JUnit 5** al `pom.xml`. Crear pruebas en `src/test/java/` (por ejemplo, probar si un Personaje pierde vida al ser atacado, límites del tablero, etc.).
- **Documentación:** Explicar qué métodos se han probado y la importancia de su ejecución con `mvn test`.

#### Paso 5: Analizador de Código (`docs/05_analizador_codigo.md`)
- **Acción:** Pedir al usuario que revise el código con SonarLint en VS Code y te comparta los avisos que le salgan. La IA proporcionará las soluciones a esos avisos.
- **Documentación:** Listar al menos 2-3 advertencias detectadas por la herramienta y explicar cómo fueron corregidas.

#### Paso 6: Javadoc (`docs/06_javadoc.md`)
- **Acción:** Añadir comentarios formales Javadoc (`/** ... */`) a las clases y métodos principales.
- **Validación:** Comprobar que se generan bien con `mvn javadoc:javadoc`.
- **Documentación:** Registrar el proceso y el comando empleado.

#### Paso 7: Integración Continua (`docs/07_integracion_continua.md`)
- **Acción:** Crear el archivo `.github/workflows/maven.yml` para configurar GitHub Actions.
- **Documentación:** Explicar el archivo YAML generado, qué comandos ejecuta (`mvn test`, `mvn package`...) y cuándo se dispara (ej: `on: push`).

#### Paso 8: Trabajo en Equipo con Git (`docs/08_trabajo_en_equipo_git.md`)
- **Acción:** Redactar un reporte de cómo se ha utilizado la rama separada, cómo se han evitado conflictos y cómo se organiza el equipo.

#### Paso 9: Diagrama de Clases UML (`docs/09_diagrama_clases.md`)
- **Acción:** Crear un diagrama de clases final usando la sintaxis **Mermaid**. Este diagrama debe reflejar la estructura *después* de la refactorización (Clases abstractas, interfaces, herencia `Personaje -> Bueno/Malo`, dependencias).
- **Documentación:** Acompañar el código Mermaid con una breve interpretación textual de las relaciones más importantes.
