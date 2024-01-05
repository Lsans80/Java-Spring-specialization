package cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.domain.Fruta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FrutaRepository extends MongoRepository<Fruta, ObjectId> {
    Optional<Fruta> findByNombre(String nombre);
}
