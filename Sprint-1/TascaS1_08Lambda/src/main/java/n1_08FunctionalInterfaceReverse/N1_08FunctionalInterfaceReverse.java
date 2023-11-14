package n1_08FunctionalInterfaceReverse;
public class N1_08FunctionalInterfaceReverse {

    public static void main (String [] args){

        String palabra = "Microscopio";
        String palabraAlreves = "";
        StringBuilder sb = new StringBuilder();

        FunctionalInterfaceReverse reverse = (palabraAlReves -> sb.reverse().toString());
        palabraAlreves = reverse.palabraAlreves(palabra);

        System.out.println(palabra);
        System.out.println(palabraAlreves);

    }
}
