# 8. Trabajo en Equipo con Git

Durante el desarrollo de esta práctica hemos organizado nuestro trabajo utilizando las herramientas de control de versiones que ofrece Git, siguiendo una serie de normas básicas para evitar conflictos y mantener el historial limpio.

## Rama utilizada

Para cumplir el requisito de no tocar la rama `main`, hemos creado desde el principio una rama específica donde se ha realizado todo el trabajo:

```bash
git checkout -b mejora-tecnica
```

Esta rama ha sido el lugar donde se han ido acumulando todos los cambios: la adaptación a Maven, las refactorizaciones, los tests, los documentos de `docs` y la configuración de GitHub Actions. La rama `main` se ha mantenido intacta como referencia del estado inicial del proyecto.

## Organización del trabajo en el equipo

Nos hemos repartido el trabajo dividiendo las tareas principales entre los miembros del equipo de la siguiente manera:

- **Configuración inicial y Maven**: adaptación de la estructura del proyecto y el `pom.xml`.
- **Análisis, refactorización y tests**: revisión del código, mejoras y escritura de pruebas unitarias.
- **Documentación y diagrama**: redacción de los ficheros Markdown de `docs` y elaboración del diagrama UML.

## Cómo evitamos sobrescribir cambios

Para evitar conflictos entre los miembros del equipo, hemos seguido estas normas básicas:

- Antes de ponerse a trabajar, cada miembro hacía siempre un `git pull` para tener la última versión.
- Cada tarea se completaba en su totalidad antes de hacer el commit, intentando que cada cambio fuera lo más pequeño y concreto posible.
- No se modificaban al mismo tiempo los mismos ficheros desde distintos ordenadores.

## Normas de commits

Los commits se han hecho con mensajes cortos pero descriptivos que indicaran qué se había cambiado, por ejemplo:

```
Añadir pom.xml y reestructurar carpetas para Maven
Simplificar switch en Malo y corregir herencia en NuevaPosicion
Añadir tests unitarios con JUnit 5
Añadir Javadoc a las clases principales
Configurar GitHub Actions para CI
Añadir diagrama de clases UML en Mermaid
```

## Sincronización final

Una vez completada la práctica, el estado final de la rama `mejora-tecnica` se puede integrar con la rama `main` mediante una pull request, que es precisamente una de las condiciones que activa nuestro flujo de GitHub Actions.
