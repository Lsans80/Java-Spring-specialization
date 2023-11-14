package n1_02Deprecated;

/*Afegeix a les classes filles alguns mètodes obsolets (deprecated),
i utilitza l’anotació corresponent.

Invoca des d'una classe externa els mètodes obsolets, suprimint mitjançant
l'anotació corresponent els “warnings” per ser obsolets.*/

public class N1_02Deprecated {
    @SuppressWarnings("deprecation")//Quitamos la advertencia (warning) de que los métodos @Deprecated están obsoletos.

    public static void main(String[] args) {

        TrabajadorOnline empleado1 = new TrabajadorOnline("Ana", "Pink", 30.5f, 40);
        TrabajadorPresencial empleado2 = new TrabajadorPresencial("Juana", "Pardo", 30.5f, 50);

        System.out.println("El sueldo de " + empleado1.getNombre() + " es de " + empleado1.calcularSueldo(160) + " Euros.");
        System.out.println("El sueldo de " + empleado2.getNombre() + " es de " + empleado2.calcularSueldo(160) + " Euros.");

        empleado1.desplazamiento();
        empleado2.dietas();

    }

}

