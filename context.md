# Enunciado de la práctica

## Proyecto de mejora técnica, documentación y modelado UML

Partiendo del juego desarrollado previamente en el módulo de Programación, y tomando como base su versión inicial por línea de comandos, deberéis realizar una mejora técnica del proyecto centrada en la calidad del código, su documentación y la representación de su estructura mediante diagramas de clases. No se trata de desarrollar un juego nuevo ni de rehacerlo desde cero, sino de trabajar sobre el proyecto ya existente para analizarlo, mejorarlo y documentarlo técnicamente.

Además, esta práctica tiene un componente importante de aprendizaje autónomo. Cada equipo deberá investigar, aprender y aplicar por sí mismo las herramientas y conceptos necesarios para realizar el trabajo, dejando constancia de ese aprendizaje dentro del propio proyecto.

---

## Requisito general de documentación del aprendizaje

Durante toda la práctica, deberéis crear dentro del proyecto un directorio llamado `docs`.

En ese directorio recogeréis la documentación del aprendizaje realizado y del trabajo técnico llevado a cabo. Esta documentación debe reflejar de forma clara:

- qué habéis tenido que aprender,
- cómo lo habéis aprendido,
- qué herramientas habéis utilizado,
- qué problemas habéis encontrado,
- qué decisiones habéis tomado,
- y cómo habéis aplicado todo ello al proyecto.

Se recomienda organizar este directorio con varios ficheros Markdown, por ejemplo:

```
docs/
├── 01_maven.md
├── 02_analisis_inicial.md
├── 03_refactorizacion.md
├── 04_pruebas_unitarias.md
├── 05_analizador_codigo.md
├── 06_javadoc.md
├── 07_integracion_continua.md
├── 08_trabajo_en_equipo_git.md
├── 09_diagrama_clases.md
└── 10_conclusiones.md
```

---

## Requisito técnico previo: uso de Maven

Para facilitar el trabajo de compilación, ejecución de pruebas, generación de documentación e integración continua, esta práctica deberá realizarse utilizando Maven.

Cada equipo deberá:

- instalar Maven en su entorno de trabajo sin privilegios de administrador,
- comprobar que puede ejecutar Maven desde terminal mediante el comando `mvn`,
- adaptar el proyecto del juego para que pueda gestionarse con Maven,
- y documentar en `docs` el proceso seguido.

En la documentación deberéis explicar, al menos:

- cómo habéis instalado Maven sin permisos de administrador,
- cómo habéis comprobado que la instalación funciona correctamente,
- cómo habéis adaptado el proyecto para usar Maven,
- qué comandos `mvn` habéis utilizado durante la práctica,
- y para qué sirve cada uno dentro de vuestro flujo de trabajo.

Durante la práctica deberéis utilizar Maven, al menos, para estas tareas:

- compilar el proyecto,
- ejecutar las pruebas unitarias,
- generar la documentación cuando corresponda.

---

## Parte A. Mejora técnica, pruebas y documentación

**Objetivo.** Aplicar sobre la versión inicial por línea de comandos del juego un proceso de mejora técnica del código, utilizando herramientas habituales de desarrollo y documentando tanto el proceso como el aprendizaje realizado.

**Condición de trabajo.** El trabajo de mejora no debe realizarse directamente sobre la rama `main`. Deberéis crear y utilizar una rama específica para esta práctica. Sobre esa rama realizaréis:

- las refactorizaciones,
- las pruebas unitarias,
- la documentación,
- y la configuración de integración continua.

La rama `main` debe mantenerse como referencia del estado inicial o estable del proyecto.

---

### 1. Análisis inicial del proyecto

Debéis revisar el código del juego y analizar su estructura actual.

En este análisis deberéis identificar:

- las clases principales,
- la responsabilidad de cada una,
- problemas de legibilidad o mantenimiento,
- duplicidades,
- métodos demasiado largos,
- nombres poco expresivos,
- ausencia de documentación,
- y posibles mejoras de organización.

Este análisis debe quedar explicado en `docs`.

---

### 2. Refactorización del código

Debéis aplicar varias mejoras de refactorización sobre el código base del juego.

Entre otras, podéis realizar acciones como:

- renombrado de clases, métodos o variables,
- extracción de métodos,
- extracción de constantes,
- eliminación de código duplicado,
- simplificación de condicionales,
- encapsulación de atributos,
- reorganización de responsabilidades entre clases,
- mejora de visibilidad,
- o separación de lógica concentrada en una sola clase.

Cada refactorización deberá documentarse indicando qué problema habéis detectado, qué cambio habéis realizado, por qué mejora el código, qué herramienta habéis utilizado, si procede, y cómo habéis comprobado que el juego sigue funcionando correctamente.

---

### 3. Implementación de pruebas unitarias

Deberéis implementar varias pruebas unitarias sobre partes relevantes de la lógica del juego.

Estas pruebas deben servir para:

- comprobar que el comportamiento esperado se mantiene,
- apoyar el proceso de refactorización,
- y permitir su ejecución automática mediante Maven y GitHub Actions.

Las pruebas deben centrarse en partes del código que puedan comprobarse de forma objetiva, por ejemplo: cálculos, reglas del juego, validaciones, gestión de puntuación, estados de partida, vidas, turnos o condiciones de victoria/derrota. En la documentación deberéis indicar qué habéis probado, por qué habéis elegido esas partes, qué comprueba cada prueba y qué resultados habéis obtenido.

---

### 4. Uso de un analizador de código

Deberéis utilizar un analizador de código compatible con Visual Studio Code.

Podéis utilizar herramientas como:

- SonarLint,
- Checkstyle,
- PMD,
- u otra alternativa equivalente compatible con Visual Studio Code.

Debéis ejecutar el análisis sobre el proyecto, identificar problemas detectados, corregir al menos una parte de ellos, y documentar qué herramienta habéis usado y qué configuración o reglas habéis revisado.

---

### 5. Documentación con Javadoc

Deberéis documentar las clases y métodos principales del proyecto utilizando Javadoc:

- las clases principales,
- los constructores relevantes,
- y los métodos más importantes para la lógica del juego.

La documentación debe ser útil, clara y coherente con el código. La documentación deberá generarse utilizando Maven, y en `docs` deberéis indicar el comando empleado y el resultado obtenido.

---

### 6. Integración continua

Deberéis configurar una acción de integración continua con GitHub Actions.

Como mínimo, la acción debe:

- ejecutarse automáticamente al hacer push o pull request,
- compilar el proyecto,
- y ejecutar las pruebas unitarias implementadas.

La acción de GitHub Actions deberá ejecutar los comandos Maven necesarios para compilar el proyecto y lanzar las pruebas unitarias. En `docs` deberéis explicar qué hace la acción, cuándo se ejecuta, cómo se relaciona con las pruebas unitarias, qué comandos Maven utiliza y qué resultados habéis obtenido.

---

### 7. Trabajo en equipo con Git

Además de utilizar Git durante la práctica, deberéis explicar en la documentación cómo habéis organizado el trabajo en equipo:

- qué rama habéis utilizado para desarrollar esta práctica,
- cómo os habéis repartido el trabajo,
- cómo habéis evitado sobrescribir cambios,
- cómo habéis integrado las aportaciones de cada miembro,
- y qué normas habéis seguido al hacer commits y sincronizar cambios.

---

## Parte B. Modelado de clases

**Objetivo.** Representar y comprender la estructura del proyecto mediante un diagrama de clases, utilizando una notación adecuada e integrando esa documentación dentro del propio repositorio.

---

### 1. Identificación de la estructura del proyecto

Debéis analizar el juego para identificar las clases principales, sus atributos, sus métodos, la visibilidad de sus miembros y las relaciones más relevantes entre clases.

---

### 2. Elaboración del diagrama de clases

Deberéis crear un diagrama de clases del proyecto. El diagrama debe representar solo las clases más importantes del sistema, es decir, aquellas que permitan entender correctamente la estructura general del juego y su funcionamiento. Debe incluir, al menos, clases principales, atributos y métodos relevantes, visibilidad y relaciones entre clases cuando existan. No se pretende representar todas las clases del proyecto, sino seleccionar adecuadamente las más importantes y mostrar con claridad la estructura básica del sistema.

---

### 3. Representación con Mermaid

El diagrama deberá realizarse utilizando Mermaid e incluirse dentro de un fichero Markdown del directorio `docs`. Por tanto, deberéis escribir el diagrama en sintaxis Mermaid, insertarlo en un fichero `.md`, comprobar que su representación es correcta y acompañarlo de una explicación textual.

---

### 4. Interpretación del diagrama

No basta con incluir el diagrama. También debéis explicar su significado. En la documentación deberéis indicar qué representa cada clase principal, cómo se relacionan entre sí, qué parte del sistema gestiona la lógica del juego, qué parte representa datos o entidades y qué posibles mejoras estructurales habéis detectado.

---

## Entrega

La entrega deberá incluir:

- el proyecto completo a partir de la versión inicial por línea de comandos del juego realizado en el módulo de Programación,
- la rama de trabajo utilizada para esta práctica,
- el directorio `docs` con toda la documentación del aprendizaje y del trabajo realizado,
- la configuración Maven del proyecto,
- las pruebas unitarias implementadas,
- la documentación Javadoc generada,
- la configuración de GitHub Actions,
- la explicación del modo de trabajo en equipo con Git,
- y el diagrama de clases en Mermaid dentro de los ficheros Markdown del proyecto.

---

## Qué se va a valorar

- la capacidad de mejorar un proyecto ya existente,
- la correcta adaptación del proyecto para trabajar con Maven,
- la instalación y uso de Maven sin privilegios de administrador,
- la calidad y justificación de las refactorizaciones,
- la adecuada utilización de una rama distinta de `main`,
- la implementación de pruebas unitarias útiles sobre la lógica del juego,
- la relación entre refactorización, pruebas, Maven y automatización,
- el uso de analizadores de código compatibles con Visual Studio Code,
- la calidad de la documentación técnica generada,
- la claridad al explicar el trabajo en equipo con Git,
- la calidad del diagrama de clases,
- la correcta utilización de Mermaid dentro de la documentación del proyecto,
- y la capacidad de aprender de forma autónoma y dejar constancia de ese aprendizaje en `docs`.