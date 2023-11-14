package n3_01Telefono;

public class Smartphone implements Telefono{

    @Override
    public void llamar() {

        System.out.println("Llamando con Smartphone.");

    }

    public void hacerFotos() {

        System.out.println("Haciendo una foto con Smartphone.");
    }
}
