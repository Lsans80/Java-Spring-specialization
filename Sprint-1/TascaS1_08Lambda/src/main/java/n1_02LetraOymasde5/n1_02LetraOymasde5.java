package n1_02LetraOymasde5;

import java.util.ArrayList;
import java.util.List;

public class n1_02LetraOymasde5 {

    public static void main(String[] args) {

        List<String> palabras = new ArrayList<>();

        palabras.add("Leche");
        palabras.add("Amiga");
        palabras.add("Carátula");
        palabras.add("Otorrino");
        palabras.add("Luisa");
        palabras.add("ESTUPENDO");

        palabras.stream()
                .filter(c -> ((c.contains("o") || c.contains("O")) && (c.length() > 5)))
                .forEach(l -> System.out.print(l + "\n"));

    }
}
