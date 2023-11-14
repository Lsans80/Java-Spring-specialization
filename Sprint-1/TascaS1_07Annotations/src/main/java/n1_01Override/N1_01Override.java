package n1_01Override;

/*Crea una jerarquia d’objectes amb tres classes:  Treballador, TreballadorOnline i TreballadorPresencial.

La classe Treballador té els atributs nom, cognom, preu/hora, i el mètode calcularSou() que rep per paràmetre
el nombre d'hores treballades i el multiplica pel preu/hora. Les classes filles l'han de sobreescriure,
emprant @Override.

Des del main() de la classe Principal, fes les invocacions necessàries per demostrar el funcionament de
l’anotació @Override.

En els treballadors presencials, el mètode per calcular el seu sou, rebrà per paràmetre
el nombre d’hores treballades al mes.

A l’hora de calcular el sou es multiplicarà el nombre d’hores treballades pel preu/hora,
més el valor d'un atribut static anomenat benzina que afegirem en aquesta classe.

En els treballadors online, el mètode per calcular el seu sou rebrà per paràmetre el nombre d'hores treballades al mes.
A l'hora de calcular el sou es multiplicarà el nombre d'hores treballades pel preu/hora i se li sumarà
el preu de la tarifa plana d'Internet, que serà una constant de la classe TreballadorOnline.*/

public class N1_01Override {
    public static void main(String[] args) {

        TrabajadorOnline empleado1 = new TrabajadorOnline("Ana","Pink", 30.5f, 40);
        TrabajadorPresencial empleado2 = new TrabajadorPresencial("Juana","Pardo", 30.5f, 50);

        System.out.println("El sueldo de " + empleado1.getNombre() + " es de " + empleado1.calcularSueldo(160)+  " Euros.");
        System.out.println("El sueldo de " + empleado2.getNombre() + " es de " + empleado2.calcularSueldo(160)+  " Euros.");

    }
}