package cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.domain.Fruta;

import java.util.List;
import java.util.Optional;

public interface FrutaService {
   Fruta addfruta (Fruta fruta);
   Optional<Fruta> getFrutabyId (int id);
   List<Fruta> getAllFruta();
   Fruta updateFruta (int id, String nuevoNombre, int nuevaCantidadKilos);
   void deleteFrutabyId(int id);

}
