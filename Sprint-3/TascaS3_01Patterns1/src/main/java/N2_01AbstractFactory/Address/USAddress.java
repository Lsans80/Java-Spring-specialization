package N2_01AbstractFactory.Address;

public class USAddress implements Address{

    private int number;
    private String street;
    private String state;
    private String zip;
    private String city;

    public USAddress(int number, String street, String state, String zip, String city) {
        this.number = number;
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public String formattedAddress() {
        return number + ", " + street + " " + state + ", " + zip + " " + city + ".";
    }

    @Override
    public String toString() {
        return "USAddress{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
