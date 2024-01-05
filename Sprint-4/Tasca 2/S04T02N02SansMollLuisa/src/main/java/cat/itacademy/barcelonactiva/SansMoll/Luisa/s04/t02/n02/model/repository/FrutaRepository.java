package cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //No es necesario, la lleva implicita JpaRepository, pero es más claro.
public interface FrutaRepository extends JpaRepository <Fruta, Integer>{

    Optional<Fruta> findByNombre(String nombre);
}
