En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

Utilizaremos el protocolo HTTP, a usar Postman, y a descubrir cómo gestionar dependencias con Maven y Gradle.


## Nivel 1

- Ejercicio Spring y Maven
 
Este ejercicio es un primer contacto con Spring y Maven.

Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:


### PROYECT (gestor de dependencias)

Maven.

### LANGUAGE

Java.

### SPRING BOOT

La última versión estable.

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t01.n01

#### Artifact

S04T01N01ApellidosNombre

#### Name

S04T01N01ApellidosNombre

#### Description

S04T01N01ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t01.n01

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

------

En el archivo application.properties, configura la variable server.port con el valor 9000.

Convertiremos esta aplicación en una API REST:

Dependiendo del package principal, crea otro subpackage llamado Controllers, y en su interior, añade la clase HelloWorldController.

#### Tendrá que tener dos métodos:
String saluda
String saluda2

#### Estos dos métodos recibirán un parámetro String llamado nombre, y devolverán la frase:

"Hola, " + nombre + ". Estás ejecutando un proyecto Maven”.

#### El primer método responderá a una petición GET y deberá ser configurado para recibir el parámetro como un RequestParam. El parámetro "nombre" tendrá el valor predeterminado “UNKNOWN”.

Deberá responder a:

http://localhost:9000/HelloWorld
http://localhost:9000/HelloWorld?nombre=Mi nombre

#### El segundo método responderá a una petición GET, y deberá ser configurado para recibir el parámetro como PathVariable. El parámetro "nombre" será opcional.

Deberá responder a:

http://localhost:9000/HelloWorld2
http://localhost:9000/HelloWorld2/mi nombre

## Recursos utilizados:

•	Youtube. Spring initializr desde Intellij IDEA, 2023, https://www.youtube.com/watch?v=RojoJvq6Rzg. Consultado el 6 de Diciembre de 2023.

•	YouTube. CURSO FULL STACK MICROSERVICIOS CON SPRING BOOT Y ANGULAR PARA PRINCIPIANTES (2024), 2023, https://www.youtube.com/watch?v=zQNnjXBQWqY&list=PLjYc2qKaQy0S-MPXQU_BDeqLIGJVXtsq9. Consultado el 10 de Diciembre de 2023.
