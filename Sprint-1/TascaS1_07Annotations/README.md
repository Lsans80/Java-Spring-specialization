# TascaS1_07Annotations

## Nivel 1

### Ejercicio 1

Crea una jerarquía de objetos con tres clases: Trabajador, Trabajador Online y Trabajador Presencial.

La clase Trabajador tiene los atributos nombre, apellido, precio/hora, y el método calcularSueldo() que recibe por parámetro el número de horas trabajadas y lo multiplica por el precio/hora. Las clases hijas deben sobreescribirlo, empleando @Override.

Desde el main() de la clase Principal, realiza las invocaciones necesarias para demostrar el funcionamiento de la anotación @Override.

En los trabajadores presenciales, el método para calcular su sueldo, recibirá por parámetro el número de horas trabajadas al mes. A la hora de calcular el sueldo se multiplicará el número de horas trabajadas por el precio/hora, más el valor de un atributo static llamado gasolina que añadiremos en esta clase.

En los trabajadores online, el método para calcular su sueldo recibirá por parámetro el número de horas trabajadas al mes. A la hora de calcular el sueldo se multiplicará el número de horas trabajadas por el precio/hora y se le sumará el precio de la tarifa plana de Internet, que será una constante de la clase Trabajador Online.

### Ejercicio 2
  
Añade a las clases hijas algunos métodos obsoletos (deprecated), y utiliza la anotación correspondiente. Invoca desde una clase externa los métodos obsoletos, suprimiendo mediante la correspondiente anotación los “warnings” para ser obsoletos.
 
