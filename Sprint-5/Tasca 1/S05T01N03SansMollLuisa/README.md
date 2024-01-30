# Objetivos de este Sprint:

- Protocol HTTP / REST.
- JPA.
- CRUD amb Spring.
- MySQL.
- Swagger.

En este Sprint encontraremos ejercicios para introducirnos en el framework SPRING.

En esta tarea realizarás un CRUD (Create, Read, Update, Delete) con 3 bases de datos diferentes.

Aprenderás a usar correctamente los verbos HTTP y gestionar los códigos de respuesta.

# Nivel 3 API Rest + API Rest

- Exercicio API Rest conectada a otra API Rest.
  
Accede a la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:

### PROYECT (gestor de dependencias)

Maven o Gradle

### LANGUAGE

Java

### SPRING BOOT

La última versión estable

### PROYECTO METADATA

#### Group

cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03

#### Artifact

S05T01N03ApellidosNombre

#### Name

S05T01N03ApellidosNombre

#### Description

S05T01N03ApellidosNombre

#### Package name

cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03

### PACKAGIN

Jar

### JAVA

Mínimo versión 11

### Dependencias:

Spring Boot DevTools

Spring Web

-------

Usando RestTemplate o WebClient, deberás conectarte a la API que has realizado en el nivel 2, para llamar y testar todas las peticiones que permite esta API.

Ten en cuenta que en esta tarea del nivel 3 no tienes ninguna referencia a ninguna base de datos, ni necesitas utilizar JPA, ya que tu repositorio accederá a la API del nivel 2.

No necesitas crear una Vista, porque este nivel 3 está previsto como una API Rest, pero tendrás que crear todas las capas hasta el controlador como cualquier otra aplicación:


- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03.controllers

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03.model.domain

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03.model.dto

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03.model.services

- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n03.model.repository

 

La clase controladora, deberá ser capaz de atender a las siguientes peticiones:

http://localhost:9002/flor/clientFlorsAdd

http://localhost:9002/flor/clientFlorsUpdate

http://localhost:9002/flor/clientFlorsDelete/{id}

http://localhost:9002/flor/clientFlorsGetOne/{id}

http://localhost:9002/flor/clientFlorsAll



Como puedes ver, en el archivo application.properties, deberás configurar que el puerto a utilizar sea el 9002.

Para probar el nivel 3, tendrás que tener en marcha la API del nivel 2. No tendrás problemas, ya que la API del nivel 3 trabaja con el puerto 9002 y la del nivel 2 con el puerto 9001.

#### Importante

Tendrás que tener en cuenta las buenas prácticas de diseño de las API, utilizando correctamente los códigos de error y las respuestas en caso de invocaciones incorrectas. (Puedes consultar información sobre ResponseEntity).

Tienes que incluir swagger para que cualquier desarrollador/a pueda tener una idea rápida de los recursos de que dispone la API.

#### Muy Importante

Además del enlace a Git de la tarea resuelta, deberás incluir al menos dos enlaces distintos de los recursos que te hemos proporcionado en el campus, que te hayan servido o pudieran hacerlo, para resolver la totalidad de la tarea o algunas partes.

------

## Recursos adicionales utilizados:

- SpringDeveloper. YouTube. Spring Tips: Spring Data JDBC, 5 Marzo 2022, https://www.youtube.com/watch?v=srBYXhhLVV4. Consultado el 3 de Enero de 2024.
  
- SACAViX Tech. YouTube. Spring Boot 3 + Swagger: Documentando una API REST desde cero, 7 Marzo 2023, https://www.youtube.com/watch?v=-SzKqwgPTyk. Consultado el 26 de Enero de 2024.
  
- Random code. YouTube. How to Call a REST API using WebClient in Spring Boot, 7 Marzo 2023, https://www.youtube.com/watch?v=RHZgllzbjVQ. Consultado el 28 de Enero de 2024.

- Like a Shark. YouTube.Manejo avanzado de excepciones con Spring boot, 22 sept 2021, https://www.youtube.com/watch?v=GfIL78RxEx8&t=115s. Consultado el 29 de Enero del 2024.  
