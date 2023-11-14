package n2_01LetraAy3letras;

/*Crea una lista de cadenas con nombres propios.

Escribe un método que devuelve una lista de todas las cadenas que comienzan con la letra 'A' (mayúscula)
y tienen exactamente 3 letras.

Imprime el resultado.*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class N2_01LetraAy3letras {

    public static void main (String [] args){

        List<String> nombres = new ArrayList<String>();

        nombres.add("Ana");
        nombres.add("Ada");
        nombres.add("Margaret");
        nombres.add("Api");
        nombres.add("Luisa");
        nombres.add("Eusebio");

        List<String> nombresconAy3letras;

        nombresconAy3letras = nombres.stream()
                .filter(nombreFiltrado -> nombreFiltrado.startsWith("A") && nombreFiltrado.length() == 3)
                .collect(Collectors.toList());

        nombresconAy3letras.forEach(System.out::println);

    }
}
