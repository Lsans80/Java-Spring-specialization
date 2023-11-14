package n1_01Nogenerico;

/*Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del mateix tipus,
juntament amb els mètodes per a emmagatzemar i extreure aquests objectes i
un constructor per a inicialitzar els tres.

Comprova que els arguments es poden posar en qualsevol posició en la crida al constructor.*/
public class N1_01Nogenerico {
    public static void main(String[] args) {

        Persona per1 = new Persona("Marta", "Black", 36);
        Persona per2 = new Persona("Natasha", "Blue", 25);
        Persona per3 = new Persona("Alex", "Spring", 43);

        //Pasamos los 3 objetos en diferente orden.

        MetodoNogenerico personas = new MetodoNogenerico(per2, per1, per3);
        MetodoNogenerico personas1 = new MetodoNogenerico(per3, per1, per2);

        System.out.println(personas.toString());
        System.out.println(personas1.toString());

    }


}

