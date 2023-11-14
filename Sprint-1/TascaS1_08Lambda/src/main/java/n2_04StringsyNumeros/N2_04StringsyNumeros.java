package n2_04StringsyNumeros;

import java.util.*;

public class N2_04StringsyNumeros {

    public static void main (String [] args){

        List<String> cosas = new ArrayList<>();

        cosas.add("3");
        cosas.add("Arbol");
        cosas.add("Martillo");
        cosas.add("10");
        cosas.add("Zapato");
        cosas.add("124");
        cosas.add("Mesa");
        cosas.add("Mezcla");

        System.out.println("Todos los elementos ordenados alfabéticamente:\n");
        cosas.sort(Comparator.comparing(s -> s.charAt(0)));
        cosas.forEach(System.out::println);

        System.out.println("\n***************\n");

        System.out.println("Todos los elementos que contengan una 'e' primero y el resto después:\n");
        cosas.stream().filter(e -> e.contains("e") || e.contains("E")).forEach(System.out::println);
        cosas.stream().filter(f -> !f.contains("e") || f.contains("E")).forEach(System.out::println);

        System.out.println("\n***************\n");

        System.out.println("Sustituimos la 'a' por un '4' de todos los elementos:\n");
        cosas.stream().forEach(c -> System.out.println(c.replace("a", "4")));//Si contiene "a" en algún punto del String lo reemplaza por "4".

        System.out.println("\n***************\n");

        System.out.println("Solo los elementos númericos de la lista:\n");
        cosas.stream().filter(n -> n.matches("\\d+")).forEach(System.out::println);

        System.out.println("\n***************\n");
    }
}
