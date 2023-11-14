package n1_04Reference;

import java.util.ArrayList;
import java.util.List;

public class N1_04Reference {

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

        //Método reference.

        meses.forEach(System.out::println);//= meses.forEach(imprimirMeses -> System.out.println(imprimirMeses));

    }
}
