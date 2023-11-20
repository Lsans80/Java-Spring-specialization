package N2_01AbstractFactory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Phone.Phone;

public class Contact {

    private Address address;
    private Phone phone;

    public Contact(Address address, Phone phone) {
        this.address = address;
        this.phone = phone;
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
        return "Agenda{" +
                "address=" + address +
                ", phone=" + phone +
                '}';
    }
}
