package N2_01AbstractFactory.Phone;

public class USPhone implements Phone{

    private static final String COUNTRYPREFIX = "+1";

    private String phone;

    public USPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String formattedPhone() {
        return COUNTRYPREFIX + phone;
    }

    @Override
    public String toString() {
        return "USPhone{" +
                "phone='" + COUNTRYPREFIX + phone + '\'' +
                '}';
    }
}
