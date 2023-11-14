package n1_06OrdenarLista;

import java.util.*;

public class N1_06OrdenarLista {

    public static void main (String[] args) {

        List<String> palabras = new ArrayList<>();

        palabras.add("Melocoton");
        palabras.add("Amada");
        palabras.add("Martillo");
        palabras.add("California");
        palabras.add("Ostentosa");
        palabras.add("Corazon");
        palabras.add("Sanacion");

        palabras.sort(Comparator.comparing(String::length));

        palabras.forEach(System.out::println);

    }
}
