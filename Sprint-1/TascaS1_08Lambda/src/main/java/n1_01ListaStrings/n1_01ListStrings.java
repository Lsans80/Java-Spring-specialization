package n1_01ListaStrings;

import java.util.ArrayList;
import java.util.List;
public class n1_01ListStrings {
    public static void main(String[] args) {

        List<String> palabras = new ArrayList<String>();

        palabras.add("Leche");
        palabras.add("Amiga");
        palabras.add("Carátula");
        palabras.add("Otorrino");
        palabras.add("Luisa");
        palabras.add("ESTUPENDO");

        palabras.stream()//convertimos nuestra colección en un flujo para procesar los datos de una manera más efectiva.
                .filter(contieneLaO -> contieneLaO.contains("o") || contieneLaO.contains("O"))//Equivale a una función anónima.
                .forEach(contieneLaO -> System.out.print(contieneLaO + "\n"));//Hace la función de un bucle forEach.


    }

}