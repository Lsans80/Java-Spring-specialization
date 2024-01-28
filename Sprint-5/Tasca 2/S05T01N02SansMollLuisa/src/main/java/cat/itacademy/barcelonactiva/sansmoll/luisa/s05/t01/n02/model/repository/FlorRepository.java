package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Integer> {

    Flor findByNombreFlor (String nombreFlor);
    void deleteByNombreFlor (String nombreFlor);
    boolean existsByNombreFlorAndPaisFlor (String nombreFlor, String paisFlor);
}
