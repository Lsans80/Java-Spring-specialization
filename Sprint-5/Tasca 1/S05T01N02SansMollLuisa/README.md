# Objetivos de este Sprint:

- Protocol HTTP / REST.
- JPA.
- CRUD amb Spring.
- MySQL.
- Swagger.

En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

En esta tarea realizarás un CRUD (Create, Read, Update, Delete) con 3 bases de datos diferentes.

Aprenderás a usar correctamente los verbos HTTP y gestionar los códigos de respuesta.

# Nivel 2 Swagger

- Exercicio aplicación Web CRUD con MySQL.
  
Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:

### PROYECT (gestor de dependencias)

Maven o Gradle

### LANGUAGE

Java

### SPRING BOOT

La última versión estable

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n02

#### Artifact

S05T01N02ApellidosNombre

#### Name

S05T01N02ApellidosNombre

#### Description

S05T01N02ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n02

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

Spring Data JPA

MySQL Driver

-------

Tenemos una entidad llamada FlorEntity, que dispone de las siguientes propiedades:

- Integer pk_FlorID

- String nombreFlor

- String paisFlor

 
También tenemos una DTO llamada FlorDTO, que tendrá las mismas propiedades que la entidad Flor, añadiendo una:

- String tipoFlor.


Esta propiedad, en función del país de la flor, deberá indicar si es “UE” o “Fuera UE”. Para ello puedes tener una lista privada en la misma DTO (por ejemplo: List<String> países), con los países que forman parte de la UE.

Aprovechando la especificación JPA, deberás persistir a la entidad Sucursal en una base de datos MySql, siguiendo el patrón MVC.

El consejo es que FlorDTO la utilices en el Controller y la Vista, y FlorEntity en el Repository. La capa de servicios será la encargada de realizar la traducción entre ambas.


Para ello, dependiendo del package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.controllers

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.domain

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.dto

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.services

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.repository


La clase ubicada en el paquete controllers (FlorController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:


http://localhost:9001/flor/add

http://localhost:9001/flor/update

http://localhost:9001/flor/delete/{id}

http://localhost:9001/flor/getOne/{id}

http://localhost:9001/flor/getAll


Como puedes ver, en el archivo application.properties, deberás configurar que el puerto a utilizar sea el 9001.

#### Importante

Tendrás que tener en cuenta las buenas prácticas de diseño de las API, utilizando correctamente los códigos de error y las respuestas en caso de invocaciones incorrectas. (Puedes consultar información sobre ResponseEntity).

Tienes que incluir swagger para que cualquier desarrollador/a pueda tener una idea rápida de los recursos de que dispone la API.

#### Muy Importante

Además del enlace a Git de la tarea resuelta, deberás incluir al menos dos enlaces distintos de los recursos que te hemos proporcionado en el campus, que te hayan servido o pudieran hacerlo, para resolver la totalidad de la tarea o algunas partes.

------

## Recursos adicionales utilizados:

- SpringDeveloper. YouTube. Spring Tips: Spring Data JDBC, 5 Marzo 2022, https://www.youtube.com/watch?v=C4YBv40Gvnk&t=1662s. Consultado el 3 de Enero de 2024.
  
- SACAViX Tech. YouTube. Spring Boot 3 + Swagger: Documentando una API REST desde cero, 7 Marzo 2023, https://www.youtube.com/watch?v=-SzKqwgPTyk. Consultado el 26 de Enero de 2024.
  
- Random code. YouTube. How to Call a REST API using WebClient in Spring Boot, 7 Marzo 2023, https://www.youtube.com/watch?v=RHZgllzbjVQ. Consultado el 28 de Enero de 2024.
