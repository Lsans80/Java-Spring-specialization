package N2_01AbstractFactory.Factory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Address.USAddress;
import N2_01AbstractFactory.Contact;
import N2_01AbstractFactory.Phone.Phone;
import N2_01AbstractFactory.Phone.USPhone;

import java.util.Scanner;

public class USContactFactory implements ContactAbstractFactory{

    Scanner sc = new Scanner(System.in);
    @Override
    public Address createAddress() {
        System.out.println("Type your number:");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Type your street:");
        String street = sc.nextLine();
        System.out.println("Type your state:");
        String state = sc.nextLine();
        System.out.println("Type your zip:");
        String zip = sc.nextLine();
        System.out.println("Type your city:");
        String city = sc.nextLine();

        return new USAddress(number, street, state, zip, city);
    }

    @Override
    public Phone createPhone() {
        System.out.println("Type your phone number:");
        String phone = sc.nextLine();

        return new USPhone(phone);
    }

    @Override
    public Contact createContact(String name, Address address, Phone phone) {

        Contact contact = new Contact(name,address, phone);
        return contact;
    }
}
