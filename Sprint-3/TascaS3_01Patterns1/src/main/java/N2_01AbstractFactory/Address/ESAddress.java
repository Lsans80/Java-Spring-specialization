package N2_01AbstractFactory.Address;

public class ESAddress implements Address{

    private String street;
    private int number;
    private int zip;

    private String city;

    public ESAddress(String street, int number, int zip, String city) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public String formattedAddress() {
        return street + ", " + number + ", " + zip + ", " + city + ".";
    }

    @Override
    public String toString() {
        return "ESAddress{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                '}';
    }
}
