package n1_07Reverse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class N1_07Reverse {

    public static void main (String[] args) {

        List<String> palabras = new ArrayList<>();

        palabras.add("Melocoton");
        palabras.add("Amada");
        palabras.add("Martillo");
        palabras.add("California");
        palabras.add("Ostentosa");
        palabras.add("Corazon");
        palabras.add("Sanacion");

        palabras.sort(Comparator.comparing(String::length).reversed());

        palabras.forEach(System.out::println);

    }
}
