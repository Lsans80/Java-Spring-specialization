package cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.domain.Fruta;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.repository.FrutaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FrutaServiceImpl implements FrutaService {
    @Autowired
    private FrutaRepository frutaRepository;
    @Override
    public Fruta addfruta(Fruta fruta) {
        Optional<Fruta> frutaExistente = frutaRepository.findByNombre(fruta.getNombre());

        if (frutaExistente.isPresent()) {
            Fruta frutaEncontrada = frutaExistente.get();
            frutaEncontrada.setCantidadKilos(frutaEncontrada.getCantidadKilos() + fruta.getCantidadKilos());
            return frutaRepository.save(frutaEncontrada);

        } else {
            return frutaRepository.save(fruta);
        }
    }
    @Override
    public Optional<Fruta> getFrutabyId(ObjectId id) {
        return frutaRepository.findById(id);
    }

    @Override
    public List<Fruta> getAllFruta() {
        return frutaRepository.findAll();
    }

    @Override
    public Fruta updateFruta(ObjectId id, String nuevoNombre, int nuevaCantidadKilos) {
        Optional<Fruta> frutaBuscada = frutaRepository.findById(id);

        if(frutaBuscada.isPresent()){
            Fruta fruta = frutaBuscada.get();
            fruta.setNombre(nuevoNombre);
            fruta.setCantidadKilos(nuevaCantidadKilos);
            return frutaRepository.save(fruta);

        } else {
            return null;
        }
    }

    @Override
    public void deleteFrutabyId(ObjectId id) {
        frutaRepository.deleteById(id);
    }
}
