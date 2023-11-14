# TascaS1_08Lambdas
 
## Para todos los ejercicios debe utilizarse la API de Java Lambdas and Streams de Java 8+.

**NIVEL 1**

**Ejercicio 1**

A partir de una lista de Strings, escribe un método que devuelve una lista de todas las cadenas que contienen la letra ‘o’. 

Imprime el resultado.

**Ejercicio 2**

Tienes que hacer lo mismo que en el punto anterior, pero ahora, el método debe devolver una lista con los Strings que además de contener la letra “o” también tienen más de 5 letras. 

Imprime el resultado.

**Ejercicio 3**

Crea una lista con los nombres de los meses del año. 

Imprime todos los elementos de la lista con una lambda.

**Ejercicio 4**

Realizar la misma impresión del punto anterior, pero mediante method reference.

**Ejercicio 5**

Crea una Functional Interface con un método llamado getPiValue() que debe devolver un double.
Desde el main() de la clase principal, instancia la interfaz y asíñale el valor 3.1415. 
Invoca el método getPiValue() e imprime el resultado.

**Ejercicio 6**

Crea una lista con números y cadenas de texto y ordena la lista con las cadenas de más corta a más larga.

**Ejercicio 7**

Con la lista del ejercicio anterior, ahora ordénala al revés, de cadena más larga a más corta.

**Ejercicio 8**

Crea una Functional Interface que contenga un método llamado reverse(). 

Este método debe recibir y debe devolver un String. En el main() de la clase principal, inyecta a la interfaz creada mediante una lambda, 
el cuerpo del método, de modo que devuelva la misma cadena que recibe como parámetro pero al revés. 

Invoca la instancia de la interfaz pasándole una cadena y comprueba si el resultado es correcto.

**NIVEL 2**

**Ejercicio 1**

Crea una lista de cadenas con nombres propios. 

Escribe un método que devuelve una lista de todas las cadenas que comienzan con la letra 'A' (mayúscula) y tienen exactamente 3 letras. 

Imprime el resultado.

**Ejercicio 2**

Programa un método que devuelve una cadena separada por comas, basada en una lista de Integers. 

Cada elemento debe ir precedido por letra “e” si el número es par, o por la letra “o” si el número es impar. 
Por ejemplo, si la lista de entrada es (3, 55, 44), la salida debe ser “o3, o55, e44”. 

Imprime el resultado.

**Ejercicio 3**

Crea una Functional Interface que contenga un método llamado operaciOn(). 

Este método debe devolver un float. Inyecta a la interfaz creada mediante una lambda, el cuerpo del método, 
de modo que se pueda transformar la operación con una suma, una resta, una multiplicación y una división.

**Ejercicio 4**

Crea una lista que contenga algunas cadenas de texto y números.

Ordénalas por:

Alfabéticamente por su primer carácter. (Nota: charAt(0) devuelve el código numérico del primer carácter)
Las cadenas que contienen una "e" primero, el resto de cadenas después. Pone el código directamente en la lambda.
Modifica todos los elementos de la lista que tienen una a. Modifica la 'a' por un '4'.
Muestra sólo los elementos que son numéricos. (Aunque estén guardados como Strings).
