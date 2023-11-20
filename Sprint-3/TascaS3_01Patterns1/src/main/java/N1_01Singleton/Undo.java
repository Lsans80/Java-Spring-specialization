package N1_01Singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instancia = null;
    private List<String> pedidos = new ArrayList<>();

    //Constructor private para instanciar a través del método instanciar().
    private Undo() {

    }
    public List<String> getPedidos() {

        return pedidos;
    }

    public void setPedidos(List<String> pedidos) {

        this.pedidos = pedidos;
    }

    public static Undo instanciar (){

        if(instancia == null){
            instancia = new Undo ();
        }
        return instancia;
    }

    public void agregarPedido (String pedido){

        pedidos.add(pedido);
    }

    public String buscarPedido (String pedido){
        String pedidoEncontrado = null;

        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).equalsIgnoreCase(pedido)) {
                pedidoEncontrado = pedido;
            }
        }
        return pedidoEncontrado;
    }

    public void eliminarPedido (String pedido){

        if(pedidos.isEmpty()){
            System.out.println("La lista está vacia.");

        } else {
            pedido = buscarPedido(pedido);

            if (pedido.equals(null)) {
                System.out.println("El pedido no se ha encontrado.");

            } else {
                pedidos.remove(pedido);
                System.out.println("El pedido " + pedido + "ha sido eliminado.");
            }
        }
    }

    public void eliminarUltimoPedido (){

        if(pedidos.isEmpty()){
            System.out.println("La lista está vacia.");

        } else {
            pedidos.remove(pedidos.size() - 1);

        }
    }

    public void listarPedidos (){

        pedidos.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Undo{" +
                "pedidos=" + pedidos +
                '}';
    }
}
