package cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.domain.Fruta;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface FrutaService {

    Fruta addfruta (Fruta fruta);
    Optional<Fruta> getFrutabyId (ObjectId id);
    List<Fruta> getAllFruta();
    Fruta updateFruta (ObjectId id, String nuevoNombre, int nuevaCantidadKilos);
    void deleteFrutabyId(ObjectId id);
}
