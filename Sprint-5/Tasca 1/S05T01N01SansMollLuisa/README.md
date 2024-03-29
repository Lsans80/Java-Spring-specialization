# Objetivos de este Sprint:

- Protocol HTTP / REST.
- JPA.
- CRUD amb Spring.
- MySQL.
- Thymeleaf.

En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

En esta tarea realizarás un CRUD (Create, Read, Update, Delete) con 3 bases de datos diferentes.

Aprenderás a usar correctamente los verbos HTTP y gestionar los códigos de respuesta.

# Nivel 1 Thymeleaf

### Vídeo de la vista del ejercicio de Sucursales

https://www.loom.com/share/1375f5770b4849aeab8eaaee5f1877e2?sid=ec033dac-2b8f-4191-b388-fc70544692ca

<br><br>

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

cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01

#### Artifact

S05T01N01ApellidosNombre

#### Name

S05T01N01ApellidosNombre

#### Description

S05T01N01ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

Spring Data JPA

MySQL Driver

Thymeleaf

-------

Tenemos una entidad llamada Sucursal, que dispone de las siguientes propiedades:

- Integer pk_SucursalID

- String nombreSucursal

- String paisSucursal

 
También tenemos una DTO llamada SucursalDTO, que tendrá las mismas propiedades que la entidad Sucursal, añadiendo una:

- String tipoSucursal.


Esta propiedad, en función del país de la sucursal, deberá indicar si es “UE” o “Fuera UE”. Para ello puedes tener una lista privada en la misma DTO (por ejemplo: List<String> países), con los países que forman parte de la UE.

Aprovechando la especificación JPA, deberás persistir a la entidad Sucursal en una base de datos MySql, siguiendo el patrón MVC.

El consejo es que SucursalDTO la utilices en el Controller y la Vista, y Sucursal en el Repository. La capa de servicios será la encargada de realizar la traducción entre ambas.


Para ello, dependiendo del package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.controllers

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.domain

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.dto

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.services

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.model.repository


La clase ubicada en el paquete controllers (SucursalController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:

http://localhost:9000/sucursal/add

http://localhost:9000/sucursal/update

http://localhost:9000/sucursal/delete/{id}

http://localhost:9000/sucursal/getOne/{id}

http://localhost:9000/sucursal/getAll


Como puedes ver, en el archivo application.properties, deberás configurar que el puerto a utilizar sea el 9000.

La vista deberá estar desarrollada con Thymeleaf.

Para que sea más atractiva, puedes usar opcionalmente alguna librería CSS que te lo facilite, como bootstrap, tailwind, material, etc.

#### Muy Importante

Además del enlace a Git de la tarea resuelta, deberás incluir al menos dos enlaces distintos de los recursos que te hemos proporcionado en el campus, que te hayan servido o pudieran hacerlo, para resolver la totalidad de la tarea o algunas partes.

------

## Recursos adicionales utilizados:

- SpringDeveloper. YouTube. Spring Tips: Spring Data JDBC, 5 Marzo 2022, https://www.youtube.com/watch?v=srBYXhhLVV4. Consultado el 3 de Enero de 2024.
  
- SACAViX Tech. YouTube. Spring Boot 3 + Swagger: Documentando una API REST desde cero, 7 Marzo 2023, https://www.youtube.com/watch?v=-SzKqwgPTyk. Consultado el 26 de Enero de 2024.
  
- Random code. YouTube. How to Call a REST API using WebClient in Spring Boot, 7 Marzo 2023, https://www.youtube.com/watch?v=RHZgllzbjVQ. Consultado el 28 de Enero de 2024.

- Like a Shark. YouTube.Manejo avanzado de excepciones con Spring boot, 22 sept 2021, https://www.youtube.com/watch?v=GfIL78RxEx8&t=115s. Consultado el 29 de Enero del 2024.
