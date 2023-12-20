# Objetivos de este Sprint:

- Protocolo HTTP
- Primer contacto con Spring
- Gestores de dependencias (Maven/Gradle)
- Postman

En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

Utilizaremos el protocolo HTTP, a usar Postman, y a descubrir cómo gestionar dependencias con Maven y Gradle.

# Nivel 1

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

# Nivel 2

- Ejercicio Spring y Gradle

Verás que este nivel es casi idéntico al nivel 1, pero utilizando Gradle como Gestor de dependencias.

Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:

### PROYECT (gestor de dependencias)

Gradle.

### LANGUAGE

Java.

### SPRING BOOT

La última versión estable.

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t01.n02

#### Artifact

S04T01N02ApellidosNombre

#### Name

S04T01N02 ApellidosNombre

#### Description

S04T01N02ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t01.n02

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

---

Importar en Eclipse con la opción File > Import > Existing Gradle Project.

En el archivo application.properties, configura la variable server.port con el valor 9001.

Convertiremos esta aplicación en una API REST:

Dependiendo del package principal, crea otro subpackage llamado Controllers, y en su interior, añade la clase HelloWorldController.

#### Tendrá que tener dos métodos:

String saluda
String saluda2

#### Estos dos métodos recibirán un parámetro String llamado "nombre" y devolverán la frase:

"Hola, " + nombre + ". Estás ejecutando un proyecto Gradle”.

#### El primer método responderá a una petición GET y deberá ser configurado para recibir el parámetro como un RequestParam. El parámetro "nombre" tendrá el valor predeterminado “UNKNOWN”.

Deberá responder a:

http://localhost:9001/HelloWorld
http://localhost:9001/HelloWorld?nombre=Mi nombre
 
#### El segundo método responderá a una petición GET, y deberá ser configurado para recibir el parámetro como PathVariable. El parámetro "nombre" será opcional.

Deberá responder a:

http://localhost:9001/HelloWorld2
http://localhost:9001/HelloWorld2/mi nombre

# Nivel 3

- Ejercicio Postman

Se trata de probar los anteriores proyectos desde Postman.

### Crea dos entornos:

- Proyecto Maven

- Proyecto Gradle

### Los dos entornos tendrán dos variables:

- Servidor, que en ambos casos tendrá el valor http://localhost

- Puerto, que en el caso del proyecto Maven tendrá el valor 9000, y en el caso del proyecto Gradle, 9001.

### ¿Qué debes entregar? (4 archivos):

- Los dos entornos exportados.

- Una captura de pantalla por cada entorno, donde se vea la ejecución desde Postman usando el entorno y las variables definidas en ellos.

- Puedes probar la URL: http://localhost:xxxx/HelloWorld/minombre, o cualquier otra de las que admiten los dos proyectos. (recuerda que para que la ejecución funcione correctamente, deberás tener en ejecución los dos proyectos en Eclipse / IntelliJ).

Ejecuta desde Eclipse / IntelliJ los proyectos creados en los dos niveles anteriores, y muestra el retorno obtenido en cada proyecto, cuando llamas a algunas de las peticiones disponibles, utilizando los entornos creados y sus variables.

Tendrás que entregar dos capturas de pantalla, una por la ejecución de cada entorno, y dos archivos con formato JSON, con los entornos exportados.

## Recursos adicionales utilizados:

•	Code Lab. Youtube. Spring initializr desde Intellij IDEA, 2023, https://www.youtube.com/watch?v=RojoJvq6Rzg. Consultado el 6 de Diciembre de 2023.

•	ZafiroDev. YouTube. CURSO FULL STACK MICROSERVICIOS CON SPRING BOOT Y ANGULAR PARA PRINCIPIANTES (2024), 2023, https://www.youtube.com/watch?v=zQNnjXBQWqY&list=PLjYc2qKaQy0S-MPXQU_BDeqLIGJVXtsq9. Consultado el 10 de Diciembre de 2023.

•	Mesa, Julián. YouTube. Tutorial básico de Postman. YouTube, 2020, https://www.youtube.com/playlist?list=PLeo6Q1inqlOeC_zQMg2i3aZcGF_Jmyqd4. Consultado el 19 de Diciembre de 2023.

•	Ravikanth FicusRoot - Tech Videos. YouTube. Postman Beginners Tutorials and Lessons, 2022, https://www.youtube.com/playlist?list=PLkLerKPSoQ_PbkN7Yz1SDliR2bRb4o_7f. Consultado el 19 de Diciembre de 2023.
