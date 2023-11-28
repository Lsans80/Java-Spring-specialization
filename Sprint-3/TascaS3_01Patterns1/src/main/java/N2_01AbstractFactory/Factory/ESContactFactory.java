package N2_01AbstractFactory.Factory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Address.ESAddress;
import N2_01AbstractFactory.Contact;
import N2_01AbstractFactory.Phone.ESPhone;
import N2_01AbstractFactory.Phone.Phone;

import java.util.Scanner;

public class ESContactFactory implements ContactAbstractFactory{

    Scanner sc = new Scanner(System.in);
    @Override
    public Address createAddress() {

        System.out.println("Dime la calle:");
        String street = sc.nextLine();
        System.out.println("Dime el número:");
        int number = sc.nextInt();
        System.out.println("Dime el código postal:");
        int zip = sc.nextInt();
        sc.nextLine();
        System.out.println("Dime la ciudad:");
        String city = sc.nextLine();

        return new ESAddress(street, number, zip, city);
    }

    @Override
    public Phone createPhone() {

        System.out.println("Dime tu número de teléfono:");
        String phone = sc.nextLine();

        return new ESPhone(phone);
    }

    @Override
    public Contact createContact(String name, Address address, Phone phone) {

        Contact contact = new Contact(name,address, phone);
        return contact;
    }
}
