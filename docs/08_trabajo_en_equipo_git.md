# 8. Trabajo en Equipo con Git

Durante el desarrollo de esta práctica hemos organizado nuestro trabajo utilizando las herramientas de control de versiones que ofrece Git, siguiendo una serie de normas básicas para mantener el historial limpio y separar claramente el estado inicial del proyecto de las mejoras realizadas.

## Rama utilizada

Para cumplir el requisito de no mezclar el trabajo de mejora con el estado estable del proyecto, hemos creado una rama específica donde se ha realizado todo el trabajo técnico:

```bash
git checkout -b mejora
```

Esta rama contiene todos los cambios de la práctica: la adaptación a Maven, las refactorizaciones, los tests, los documentos de `docs`, la configuración de GitHub Actions y el diagrama de clases. La rama `master` se ha mantenido como referencia del estado inicial del juego.

## Organización del trabajo

El proyecto ha sido desarrollado de forma individual. Para cumplir con el requisito técnico de separación de ramas se ha aplicado la siguiente estrategia al finalizar el trabajo:

1. Se creó la rama `mejora` apuntando al estado con todas las mejoras aplicadas.
2. Se realizó un único commit en esa rama agrupando todo el trabajo técnico realizado.
3. La rama `master` se restauró al commit `fa3311f` (`first phase done`), que representa el estado inicial del juego tal como se entregó en la primera fase de la asignatura.

Esto se consiguió con los siguientes comandos:

```bash
# Crear la rama de trabajo con todo el trabajo ya hecho
git checkout -b mejora

# Añadir y commitear todo el trabajo pendiente
git add pom.xml src/main/ src/test/ docs/ .github/ bin/main/
git commit -m "Mejora técnica: migración a Maven, refactorización, tests, Javadoc, CI y documentación"

# Restaurar master al estado inicial del juego
git checkout master
git reset --hard fa3311f

# Publicar ambas ramas
git push origin master --force
git push origin mejora
```

## Normas de commits seguidas

Los commits se han hecho con mensajes descriptivos que indican el alcance del cambio, siguiendo el criterio de que cada commit refleje una unidad de trabajo completa y coherente:

```
first phase done          ← estado inicial del juego (rama master)
proyect done              ← versión previa a Maven (descartada del historial activo)
Mejora técnica: ...       ← todo el trabajo de la práctica (rama mejora)
```

## Estado final del repositorio

```
master  →  fa3311f  first phase done          (estado inicial, referencia estable)
mejora  →  14edda9  Mejora técnica: ...       (todo el trabajo de esta práctica)
```

La rama `mejora` es la que activa el flujo de integración continua de GitHub Actions al hacer push, y la que se integraría con `master` mediante una pull request para dar por cerrada la práctica.
