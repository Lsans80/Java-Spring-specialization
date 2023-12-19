# TascaS3_01Patterns1

La utilización de patrones es fundamental en la construcción de un software extensible y reutilizable. 
El lenguaje Java, así como todos los frameworks de software, están hechos de acuerdo a los patrones más importantes del software.

## Nivel 1

En todos los ejercicios, crea un proyecto con una clase Main que demuestre el uso del patrón (con las necesarias invocaciones).

### Singleton

Crea una clase que replique el funcionamiento del comando 'Undo'. Esta clase será utilizada por la clase Main, que permitirá introducir opciones por consola.

La clase 'Undo' debe guardar los últimos pedidos introducidos. Debe permitir añadir o eliminar pedidos, así como listar los últimos pedidos introducidos (similar al comando 'history' en Linux).
La clase 'Undo' debe implementar imprescindiblemente un patrón Singleton.

## Nivel 2

### Abstract Factory

Crea un pequeño gestor de direcciones y números de teléfono internacionales.

La aplicación debe permitir añadir a la agenda, direcciones y números de teléfono internacionales. Teniendo en cuenta los distintos formatos de los distintos países, construye la agenda, las direcciones y los teléfonos implementando un patrón Abstract Factory.

## Nivel 3

### Command

Diseña un parking de 4 vehículos: un coche, una bicicleta, un avión y un barco.

Muestra cómo funciona el patrón Command que implementa los métodos arrancar, acelerar y frenar para cada tipo de vehículo.
