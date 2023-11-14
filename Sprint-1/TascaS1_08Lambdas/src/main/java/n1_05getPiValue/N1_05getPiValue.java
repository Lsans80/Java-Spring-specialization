package n1_05getPiValue;

public class N1_05getPiValue {
    public static void main (String[] args) {

        FunctionalInterface pi = () -> 3.1415;

        System.out.println(pi.getPiValue());

    }

}
