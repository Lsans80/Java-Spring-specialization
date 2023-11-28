package N2_01AbstractFactory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Factory.ContactAbstractFactory;
import N2_01AbstractFactory.Factory.ESContactFactory;
import N2_01AbstractFactory.Factory.USContactFactory;
import N2_01AbstractFactory.Phone.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    static Scanner sc = new Scanner(System.in);
    static List<Contact> contactList = new ArrayList<>();

    public static void start() {

        boolean salir = false;

        do{
            switch(menu()){
                case 1: crearContacto();
                    break;
                case 2: buscarContacto();
                    break;
                case 3: eliminarContacto();
                    break;
                case 4: listarContactos();
                    break;
                case 0: System.out.println("Hasta pronto!");
                    salir = true;
                    break;
            }
        }while(!salir);
    }

    public static byte menu(){

        byte opcion;
        final byte MINIMO = 0;
        final byte MAXIMO = 4;

        do{
            System.out.println("\n*****AGENDA*****");
            System.out.println("1. Crear contacto.");
            System.out.println("2. Buscar contacto.");
            System.out.println("3. Eliminar contacto.");
            System.out.println("4. Listar contactos.");
            System.out.println("0. Salir de la agenda.\n");
            opcion = sc.nextByte();
            sc.nextLine();

            if(opcion < MINIMO || opcion > MAXIMO){
                System.out.println("Escoge una opción válida.");
            }

        } while(opcion < MINIMO || opcion > MAXIMO);

        return opcion;
    }

    public static void crearContacto(){

        System.out.println("Qué contacto quieres crear?\n1.Contacto ES.\n2.Contacto US.");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion){

            case 1:
                crearContactoES();
                break;

            case 2:
                crearContactoUS();
                break;
        }
    }
    public static void crearContactoES(){

        ContactAbstractFactory factory = new ESContactFactory();

        System.out.println("Dime tu nombre completo:");
        String name = sc.nextLine();
        Address address = factory.createAddress();
        Phone phone = factory.createPhone();

        Contact contact = factory.createContact(name, address, phone);
        contactList.add(contact);

        System.out.println("Nombre completo: " + name);
        System.out.println("Dirección: " + address.formattedAddress());
        System.out.println("Teléfono: " + phone.formattedPhone());
        System.out.println("Tus datos han sido agregados correctamente!");
    }

    public static void crearContactoUS(){

        ContactAbstractFactory factory = new USContactFactory();

        System.out.println("Type your full name:");
        String name = sc.nextLine();
        Address address = factory.createAddress();
        Phone phone = factory.createPhone();

        Contact contact = factory.createContact(name, address, phone);
        contactList.add(contact);

        System.out.println("Full name: " + name);
        System.out.println("Address: " + address.formattedAddress());
        System.out.println("Phone Number: " + phone.formattedPhone());
        System.out.println("Your data was added successfully!");

    }

    public static Contact buscarContacto(){

        System.out.println("Dime el nombre del contacto:\nType the full name of the contact:");
        String name = sc.nextLine();

        for(int i = 0; i<contactList.size(); i++){

            if(contactList.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(contactList.get(i));
                return contactList.get(i);
            }
        }

        return null;
    }
    public static void eliminarContacto(){

        Contact contact = buscarContacto();

        if(contact == null){
            System.out.println("El contacto no se ha encontrado.");

        } else {
            System.out.println("El contacto ha sido eliminado.");
            contactList.remove(contact);
        }

    }
    public static void listarContactos(){

        if(contactList.isEmpty()){
            System.err.println("Lista de contactos vacia.");

        } else {
            contactList.forEach(System.out::println);
        }
    }

}
