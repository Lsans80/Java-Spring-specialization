package n2_02ListaIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class N2_02ListaIntegers {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        numeros.add(3);
        numeros.add(6);
        numeros.add(9);
        numeros.add(10);
        numeros.add(8);

        String parImpar = numeros.stream()
                .map(n -> (n % 2 == 0 ? "e" : "o") + n )//.map para aplicar la función lambda a cada elemento.
                .collect(Collectors.joining(" ,"));

        System.out.println(parImpar);
    }

}
