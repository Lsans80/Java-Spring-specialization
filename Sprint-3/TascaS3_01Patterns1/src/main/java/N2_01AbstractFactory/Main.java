package N2_01AbstractFactory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Factory.ESContactFactory;
import N2_01AbstractFactory.Factory.USContactFactory;
import N2_01AbstractFactory.Phone.Phone;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String [] args){

        List<Contact> contactList = new ArrayList<>();

        //Instanciamos las fabricas para diferentes paises.

        ESContactFactory esContact = new ESContactFactory();
        USContactFactory usContact = new USContactFactory();

        //Creamos direcciones + teléfonos por país.

        Address esAddress = esContact.createAddress();
        Phone esPhone     = esContact.createPhone();

        Address usAddress = usContact.createAddress();
        Phone usPhone     = usContact.createPhone();

        //Creamos objetos de la clase Contact (Address + Phone).

        Contact contact = new Contact(esAddress,esPhone);
        Contact contact1 = new Contact(usAddress,usPhone);

        //Agregamos a la agenda.

        contactList.add(contact);
        contactList.add(contact1);

        //Imprimimos la lista de contactos.

        contactList.forEach(System.out::println);

        //Mostramos los datos en formato legible según el país.

        System.out.println("Dirección: " + esAddress.formattedAddress());
        System.out.println("Teléfono: " + esPhone.formattedPhone());
        System.out.println("Tus datos han sido agregados correctamente!");

        System.out.println("Address: " + usAddress.formattedAddress());
        System.out.println("Phone Number: " + usPhone.formattedPhone());
        System.out.println("Your data was added successfully!");

    }
}
