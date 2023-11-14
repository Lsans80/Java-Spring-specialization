package n2_03Operacion;

public class n2_03Operacion {

    public static void main (String [] args){

        Calculadora suma = (a,b)-> a+b;
        Calculadora resta = (a,b)-> a-b;
        Calculadora multiplicacion = (a,b)-> a*b;
        Calculadora division = (a,b)-> {
            if (b != 0){
                return a/b;
            } else {
                throw new ArithmeticException("NO se puede dividir entre 0.");

            }
        };

        float resultadoSuma = suma.operacion(6, 3);
        float resultadoResta = resta.operacion(9, 2);
        float resultadoMultiplicacion = multiplicacion.operacion(8, 2);
        float resultadoDivision = division.operacion(10, 3);

        System.out.println("Suma: " + resultadoSuma);
        System.out.println("Resta: " + resultadoResta);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        System.out.println("División: " + resultadoDivision);

    }
}
