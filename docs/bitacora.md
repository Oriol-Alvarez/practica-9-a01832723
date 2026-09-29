# Bitácora - Práctica 9: Tareas con Hilt

## Ejercicio A2: ¿Qué tendrías que cambiar?

Para mostrar solo "Tarea de prueba" sin tocar ApiRemota, tendría que modificar directamente TareasRepository.kt (o TareasViewModel.kt), comentando la llamada a api.descargarTareas() y regresando una lista fija con la tarea de prueba escrita a mano. Para volver a los datos reales, tendría que volver a editar el archivo y deshacer los cambios manualmente. El problema es que en el código soldado ambas fuentes no pueden coexistir; solo hay una clase concreta que decide por sí misma de dónde sacar los datos.

## Ejercicio E1: ¿Por qué bastó una línea?

Solo tuve que cambiar un archivo: RepositorioModule.kt, cambiando TareasRepositoryReal por TareasRepositoryFalso en la función con @Binds.

En el starter habría tenido que modificar TareasRepository.kt, el ViewModel o ambos, y si la app fuera más grande, modificar cada clase que construyera el repositorio.

Ni el ViewModel ni la pantalla se enteraron porque ambos están programados contra la interfaz TareasRepository (el "enchufe") y no contra una clase concreta. Toda la decisión de qué implementación usar está centralizada en el módulo de Hilt.

## Ejercicio E2: Boleto de salida

1. ¿Qué es inyección de dependencias?
Es el patrón de diseño donde una clase recibe las dependencias que necesita por su constructor en vez de construirlas ella misma internamente.

2. ¿Para qué sirve la interfaz TareasRepository?
Sirve como un contrato o enchufe abstracto para desacoplar el ViewModel de la fuente de datos, permitiendo intercambiar la implementación real o la de prueba sin modificar la UI ni el ViewModel.

3. ¿Qué hace @Binds en un módulo de Hilt?
Le indica a Hilt qué implementación concreta debe usar y entregar cada vez que una clase pida una interfaz en su constructor.
