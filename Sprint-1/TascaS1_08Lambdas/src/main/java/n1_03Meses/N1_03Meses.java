package n1_03Meses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1_03Meses {

    public static void main (String[] args){

        List<String> meses = new ArrayList<>();

        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");

        meses.forEach(i -> System.out.println(i));//= meses.forEach(System.out::println);

    }
}
