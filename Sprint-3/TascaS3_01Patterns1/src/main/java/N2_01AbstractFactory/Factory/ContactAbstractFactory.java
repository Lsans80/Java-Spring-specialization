package N2_01AbstractFactory.Factory;

import N2_01AbstractFactory.Address.Address;
import N2_01AbstractFactory.Phone.Phone;

public interface ContactAbstractFactory {
    Address createAddress ();
    Phone createPhone ();


}
