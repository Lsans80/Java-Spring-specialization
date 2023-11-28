package N2_01AbstractFactory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Phone.Phone;

public class Contact {

    private String name;
    private Address address;
    private Phone phone;

    public Contact(String name, Address address, Phone phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Contact(Address address, Phone phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + "{" +
                "address=" + address +
                ", phone=" + phone +
                '}';
    }
}
