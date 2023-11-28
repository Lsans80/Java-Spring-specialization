package N1_01Singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instancia;
    private List<String> comandos;

    //Constructor private para instanciar a través del método instanciar().
    private Undo() {
        this.comandos = new ArrayList<>();
    }

    public static Undo instanciar (){

        if(instancia == null){
            instancia = new Undo ();
        }
        return instancia;
    }

    public void agregarComando (String pedido){

        comandos.add(pedido);
    }

    public void eliminarUltimoComando (){

        if(comandos.isEmpty()){
            System.out.println("La lista está vacia.");

        } else {
            comandos.remove(comandos.size() - 1);

        }
    }

    public void listarComandos (){

        comandos.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Undo{" +
                "pedidos=" + comandos +
                '}';
    }
}
