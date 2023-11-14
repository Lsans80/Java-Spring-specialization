USE universidad;

/*1.Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos/as. 
El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.*/

SELECT apellido1,
		apellido2,
        nombre
FROM persona
WHERE tipo = 'alumno'
ORDER BY apellido1, apellido2, nombre;

-- 2.Halla el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.

SELECT nombre,
		apellido1,
        apellido2
FROM persona
WHERE tipo = 'alumno' AND telefono IS NULL;

-- 3.Devuelve el listado de los alumnos que nacieron en 1999.

SELECT nombre, 
		fecha_nacimiento
FROM persona
WHERE fecha_nacimiento BETWEEN '1999-01-01' AND '1999-12-31';

/*4.Devuelve el listado de profesores/as que no han dado de alta su número de teléfono en la base de datos 
y además su NIF termina en K.*/

SELECT nif,
		nombre,
        apellido1,
        apellido2,
        telefono
FROM persona
WHERE tipo = 'profesor' 
	AND telefono IS NULL 
	AND RIGHT(nif,1) = 'K';
    
/*5.Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, 
en el tercer curso del grado que tiene el identificador 7.*/

SELECT g.id AS idGrado,
		a.id AS idAsignatura,
		a.nombre,
        curso,
        cuatrimestre
FROM grado g
JOIN asignatura a ON g.id = a.id_grado
WHERE g.id = 7 AND curso = 3 AND cuatrimestre = 1;

/*6.Devuelve un listado de los profesores/as junto con el nombre del departamento al que están vinculados. 
El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. 
El resultado estará ordenado alfabéticamente de menor a mayor por apellidos y nombre.*/

SELECT apellido1,
		apellido2,
        per.nombre,
        d.nombre AS nombreDepartamento
FROM profesor p
JOIN departamento d ON d.id = p.id_departamento
JOIN persona per ON per.id = p.id_profesor
ORDER BY apellido1, apellido2, per.nombre;

-- 7.Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno/a con NIF 26902806M.

SELECT asig.nombre AS nombreAsignatura,
		anyo_inicio,
        anyo_fin,
        p.nif
FROM alumno_se_matricula_asignatura a
JOIN persona p ON a.id_alumno = p.id
JOIN asignatura asig ON a.id_asignatura = asig.id
JOIN curso_escolar c ON a.id_curso_escolar = c.id
WHERE p.nif = "26902806M";

/*8.Devuelve un listado con el nombre de todos los departamentos que tienen profesores/as que imparten alguna asignatura 
en el Grado en Ingeniería Informática (Plan 2015).*/
-- Grado en Ingeniería Informática (Plan 2015) = 4

SELECT d.nombre AS Departamento, p.id_profesor, a.nombre AS Asignatura
FROM asignatura a
JOIN profesor p ON a.id_profesor = p.id_profesor
JOIN departamento d ON p.id_departamento = d.id;

-- 9.Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.

SELECT DISTINCT id_alumno, nif, nombre, apellido1, apellido2, anyo_inicio, anyo_fin
FROM curso_escolar c
JOIN alumno_se_matricula_asignatura am ON am.id_curso_escolar = c.id
JOIN persona p ON am.id_alumno = p.id
WHERE c.anyo_inicio = 2018;

-- LEFT JOIN i RIGHT JOIN.

/*1. Devuelve un listado con los nombres de todos los profesores/as y los departamentos que tienen vinculados. 
El listado también debe mostrar aquellos profesores/as que no tienen ningún departamento asociado. 
El listado debe devolver cuatro columnas, nombre del departamento, primer apellido, segundo apellido y nombre del profesor/a. 
El resultado estará ordenado alfabéticamente de menor a mayor por el nombre del departamento, apellidos y nombre.*/

SELECT d.nombre AS nombreDepartamento, apellido1, apellido2, per.nombre
FROM persona per
LEFT JOIN  profesor p ON per.id = p.id_profesor
LEFT JOIN departamento d ON d.id = p.id_profesor
WHERE tipo = "profesor"
ORDER BY d.nombre, apellido1, apellido2, per.nombre;

-- 2.Devuelve un listado con los profesores/as que no están asociados a un departamento.

SELECT nombre, apellido1, apellido2, tipo, id_departamento
FROM persona per
LEFT JOIN  profesor p ON per.id = p.id_profesor
WHERE tipo = "profesor" ;

-- 3.Devuelve un listado con los departamentos que no tienen profesores asociados.

SELECT id_profesor, id AS id_departamento, nombre
FROM profesor p
RIGHT JOIN departamento d ON p.id_departamento = d.id
WHERE id_profesor IS NULL;

-- 4.Devuelve un listado con los profesores/as que no imparten ninguna asignatura.

SELECT p.id_profesor, per.nombre, per.apellido1, per.apellido2, a.id AS idAsignatura
FROM asignatura a
RIGHT JOIN profesor p ON a.id_profesor = p.id_profesor
RIGHT JOIN persona per ON p.id_profesor = per.id 
WHERE per.tipo = "profesor" AND a.id IS NULL;

-- 5.Devuelve un listado con las asignaturas que no tienen un profesor/a asignado.

SELECT *
FROM asignatura a
WHERE id_profesor IS NULL;

-- 6.Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.

SELECT DISTINCT d.nombre AS Departamento, ce.id AS Curso_Escolar 
FROM alumno_se_matricula_asignatura aa 
RIGHT JOIN asignatura a ON aa.id_asignatura = a.id 
RIGHT JOIN curso_escolar ce ON aa.id_curso_escolar = ce.id 
RIGHT JOIN profesor p ON a.id_profesor = p.id_profesor 
RIGHT JOIN departamento d ON p.id_departamento = d.id 
WHERE ce.id IS NULL;

-- CONSULTAS RESUMEN:

-- 1.Devuelve el número total de alumnos existentes.

SELECT COUNT(id) AS TotalAlummos
FROM persona 
WHERE tipo = "alumno";

-- 2.Calcula cuántos alumnos nacieron en 1999.

SELECT COUNT(id) AS Nacidos_1999
FROM persona
WHERE fecha_nacimiento BETWEEN "1999-01-01" AND "1999-12-31" 
	AND tipo = "alumno";

/*3.Calcula cuántos profesores/as hay en cada departamento. 
El resultado sólo debe mostrar dos columnas, una con el nombre del departamento y otra con el número de profesores/as que hay 
en ese departamento. 
El resultado sólo debe incluir los departamentos que tienen profesores/as asociados y tendrá que estar ordenado 
de mayor a menor por el número de profesores/as.
*/ 

SELECT COUNT(id_profesor) AS Total_profesores, nombre
FROM profesor p
JOIN departamento d ON p.id_departamento = d.id
GROUP BY nombre
ORDER BY Total_profesores DESC;

/*4.Devuelve un listado con todos los departamentos y el número de profesores/as que hay en cada uno de ellos. 
Tenga en cuenta que pueden existir departamentos que no tienen profesores asociados. 
 departamentos también deben aparecer en el listado.*/
 
 SELECT nombre, COUNT(id_profesor) AS Total_profesores
 FROM profesor p
 RIGHT JOIN departamento d ON p.id_departamento = d.id
 GROUP BY nombre
 ORDER BY nombre;
 
 /*5.Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno. 
 Ten en cuenta que pueden existir grados que carecen de asignaturas asociadas. Estos grados también deben aparecer en el listado. 
 El resultado deberá estar ordenado de mayor a menor por el número de asignaturas.*/
 
 SELECT COUNT(a.id) AS Total_asignaturas, g.nombre
 FROM asignatura a
 RIGHT JOIN grado g ON a.id_grado = g.id
 GROUP BY nombre
 ORDER BY Total_asignaturas DESC;
 
 /*6.Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno, 
 de los grados que tengan más de 40 asignaturas asociadas.*/
 
 SELECT COUNT(a.id) AS Numero_asignaturas, g.nombre
 FROM asignatura a
 JOIN grado g ON a.id_grado = g.id
 GROUP BY g.nombre 
 HAVING COUNT(a.id) > 40;
 
 /*7.Devuelve un listado que muestre el nombre de los grados y la suma del número total de créditos existentes para cada tipo de asignatura. 
 El resultado debe tener tres columnas: nombre del grado, tipo de asignatura y la suma de los créditos de todas las asignaturas que existen de este tipo.*/

SELECT g.nombre AS NombreAsignatura, a.tipo, SUM(a.creditos) AS TotalCreditos
FROM asignatura a
JOIN grado g ON a.id_grado = g.id
GROUP BY g.nombre, a.tipo;


/*8.Devuelve un listado que muestre cuántos alumnos se han matriculado de alguna asignatura en cada uno de los cursos escolares. 
El resultado tendrá que mostrar dos columnas, una columna con el año de inicio del curso escolar y otra con el número de alumnos matriculados.*/

SELECT anyo_inicio, COUNT(id_alumno) AS CantidadAlumnos
FROM alumno_se_matricula_asignatura a
JOIN curso_escolar c ON a.id_curso_escolar = c.id
GROUP BY anyo_inicio;

/*9.Devuelve un listado con el número de asignaturas que imparte cada profesor/a. 
El listado debe tener en cuenta a aquellos profesores/as que no imparten ninguna asignatura. 
El resultado mostrará cinco columnas: id, nombre, primer apellido, segundo apellido y número de asignaturas. 
El resultado estará ordenado de mayor a menor por el número de asignaturas.*/

SELECT p.id_profesor, per.nombre, per.apellido1, per.apellido2, COUNT(a.id) AS TotalAsignaturas 
FROM asignatura a
RIGHT JOIN profesor p ON a.id_profesor = p.id_profesor
LEFT JOIN persona per ON p.id_profesor = per.id
GROUP BY p.id_profesor
ORDER BY TotalAsignaturas DESC;

-- 10.Devuelve todos los datos del alumno/a más joven.

SELECT *
FROM persona
WHERE tipo = "alumno"
ORDER BY fecha_nacimiento
LIMIT 1;

-- 11.Devuelve un listado con los profesores/as que tienen un departamento asociado y que no imparten ninguna asignatura.

SELECT id_departamento, p.id_profesor, per.nombre, per.apellido1, per.apellido2, a.nombre AS NombreAsignatura
FROM profesor p
JOIN persona per ON  p.id_profesor = per.id
LEFT JOIN asignatura a ON per.id = a.id_profesor
WHERE a.nombre IS NULL;











