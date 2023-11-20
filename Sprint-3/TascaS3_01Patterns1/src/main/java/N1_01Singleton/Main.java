package N1_01Singleton;

public class Main {

    public static void main(String[] args){

        //Instanciamos a traves del metodo static.
        Undo pedido = Undo.instanciar();

        pedido.agregarPedido("pedido1");
        pedido.agregarPedido("pedido2");
        pedido.agregarPedido("pedido3");
        pedido.agregarPedido("pedido4");

        pedido.listarPedidos();
        System.out.println();

        pedido.eliminarPedido("pedido3");
        pedido.listarPedidos();
        System.out.println();

        pedido.eliminarUltimoPedido();
        pedido.listarPedidos();

    }
}
