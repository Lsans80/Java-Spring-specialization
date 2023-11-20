package N2_01AbstractFactory.Phone;

public class ESPhone implements Phone{

    private static final String COUNTRYPREFIX = "+34";
    private String phone;

    public ESPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String formattedPhone() {
        return COUNTRYPREFIX + phone;
    }

    @Override
    public String toString() {
        return "ESPhone{" +
                "phone=" + COUNTRYPREFIX + phone +
                '}';
    }
}
