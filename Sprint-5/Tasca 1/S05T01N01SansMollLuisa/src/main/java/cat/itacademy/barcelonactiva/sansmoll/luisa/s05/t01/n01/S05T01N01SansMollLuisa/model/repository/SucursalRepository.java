package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.repository;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository <Sucursal, Integer>{

    Sucursal findByNombreSucursal (String nombreSucursal);
    void deleteByNombreSucursal(String nombreSucursal);
    boolean existsByNombreSucursalAndPaisSucursal(String nombreSucursal, String paisSucursal);
}
