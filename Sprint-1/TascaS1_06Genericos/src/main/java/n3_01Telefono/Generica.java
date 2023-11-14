package n3_01Telefono;

class Generica {

    public <T extends Telefono> void metodoTelefono (T telefono){

        telefono.llamar();
        //telefono.hacerFotos() no es posible ya que esta limitado a la interfaz
        // y desde ahi no podemos acceder a los métodos de Smartphone.
        }

    public <T extends Smartphone> void metodoSmartphone (T smartphone){

        smartphone.llamar();
        smartphone.hacerFotos();
    }
}
