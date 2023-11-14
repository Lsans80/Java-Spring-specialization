package n1_02Generico;

/*Crea una classe anomenada Persona amb els atributs nom, cognom i edat.

Després crea una classe anomenada GenericMethods amb un mètode genèric
que accepti tres arguments de tipus genèric.

Aquest mètode només ha d’imprimir per pantalla els arguments que ha rebut.

Al main() de la classe principal, crida el mètode genèric amb diferents tipus de paràmetres.

Exemple: un objecte de la classe Persona, un String i un tipus primitiu.

D’aquesta manera has comprovat que se li pot passar qualsevol tipus de paràmetre i en qualsevol ordre.*/

public class MetodoGenerico {

    public static void main(String[] args) {
        Persona pers1 = new Persona("Luisa", "Blue",33);

        MetodoGenerico.soyUnmetodoGenerico(pers1,"Chocolate",333);
        MetodoGenerico.soyUnmetodoGenerico(333,pers1,"Chocolate");

    }
    public static <T> void soyUnmetodoGenerico (T uno, T dos, T tres){
        System.out.println("Soy el dato genérico uno: " + uno);
        System.out.println("Soy el dato genérico dos: " + dos);
        System.out.println("Soy el dato genérico tres: " + tres);

    }
}
