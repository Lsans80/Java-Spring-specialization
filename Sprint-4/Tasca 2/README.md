# Objetivos de este Sprint:

- HTTP Verbs.
- HTTP Headers.
- HTTP Status Codes.
- CRUD con Spring boot.
- H2, MySQL, MongoDB.

En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

En esta tarea realizarás un CRUD (Create, Read, Update, Delete) con 3 bases de datos diferentes.

Aprenderás a usar correctamente los verbos HTTP y gestionar los códigos de respuesta.

# Nivel 1

- Ejercicio CRUD con H2
  
Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:

### PROYECT (gestor de dependencias)

Maven o Gradle

### LANGUAGE

Java

### SPRING BOOT

La última versión estable

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01

#### Artifact

S04T02N01ApellidosNombre

#### Name

S04T02N01ApellidosNombre

#### Description

S04T02N01ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

Spring Data JPA

H2 Database

-------

Tenemos una entidad llamada "Fruta", que dispone de las siguientes propiedades:

int id
String nombre
Int cantidadQuilos

Aprovechando la especificación JPA, deberás persistir esta entidad en una base de datos H2, siguiendo el patrón MVC.

Para ello, dependiendo del Package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.controllers
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.domain
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.services
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.repository

La clase ubicada en el paquete controllers (FruitaController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:

http://localhost:8080/fruta/add

http://localhost:8080/fruta/update

http://localhost:8080/fruta/delete/{id}

http://localhost:8080/fruta/getOne/{id}

http://localhost:8080/fruta/getAll

 
#### Importante

Tendrás que tener en cuenta las buenas prácticas de diseño de las API, utilizando correctamente los códigos de error y las respuestas en caso de invocaciones incorrectas. (Puedes consultar información sobre ResponseEntity).

#### Muy Importante

Además del enlace a Git de la tarea resuelta, deberás incluir al menos dos enlaces distintos de los recursos que te hemos proporcionado en el campus, que te hayan servido o pudieran hacerlo, para resolver la totalidad de la tarea o algunas partes.

# Nivel 2

- Ejercicio CRUD con MySQL
  
Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:


### PROYECT (gestor de dependencias)

Maven o Gradle

### LANGUAGE

Java

### SPRING BOOT

La última versión estable

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n02

#### Artifact

S04T02N02ApellidosNombre

#### Name

S04T02N02ApellidosNombre

#### Description

S04T02N02ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n02

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

Spring Data JPA

MySQL Driver

-----

Tienes que hacer lo mismo que en el nivel 1, pero persistiendo los datos en MySQL.

# Nivel 3

- Ejercicio CRUD con MongoDB
  
Accede a la página ->https://start.spring.io/, genera un proyecto Spring boot con las siguientes características:

### PROYECT (gestor de dependencias)

Maven o Gradle

### LANGUAGE

Java

### SPRING BOOT

La última versión estable

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n03

#### Artifact

S04T02N03ApellidosNombre

#### Name

S04T02N03ApellidosNombre

#### Description

S04T02N03ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n03

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

Spring Data JPA

Spring Data MongoDB

-----

Tienes que hacer lo mismo que en el nivel 1, pero persistiendo los datos en MongoDB.

## Recursos adicionales utilizados:

-	MitoCode. YouTube. Spring Boot, 31 Marzo 2019, https://www.youtube.com/playlist?list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl. Consultado el 3 de Enero de 2024.

-	realNameHidden. YouTube. Custom Queries with Spring Data JPA’s @Query Annotation | Spring Data JPA @Query, 5 Marzo 2022, https://www.youtube.com/watch?v=C4YBv40Gvnk&t=1662s. Consultado el 3 de Enero de 2024.
