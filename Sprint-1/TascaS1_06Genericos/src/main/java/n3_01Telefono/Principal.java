package n3_01Telefono;

public class Principal {

    public static void main(String[] args) {

        Generica generica = new Generica();
        Smartphone smartphone = new Smartphone();

        generica.metodoTelefono(smartphone);
        generica.metodoSmartphone(smartphone);
    }

}
