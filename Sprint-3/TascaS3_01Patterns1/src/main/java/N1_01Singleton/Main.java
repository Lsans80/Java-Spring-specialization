package N1_01Singleton;

public class Main {

    public static void main(String[] args){

        //Instanciamos a traves del metodo static.
        Undo comandos = Undo.instanciar();

        comandos.agregarComando("comando1");
        comandos.agregarComando("comando2");
        comandos.agregarComando("comando3");
        comandos.agregarComando("comando4");

        comandos.listarComandos();
        System.out.println();

        comandos.eliminarUltimoComando();
        comandos.listarComandos();
        System.out.println();

    }
}
