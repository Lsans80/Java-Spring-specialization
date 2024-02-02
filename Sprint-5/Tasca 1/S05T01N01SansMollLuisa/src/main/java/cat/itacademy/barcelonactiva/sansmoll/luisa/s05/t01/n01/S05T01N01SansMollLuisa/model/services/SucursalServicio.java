package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalServicio {

    SucursalDTO addSucursal (SucursalDTO sucursalDTO);
    SucursalDTO getOneSucursal (Integer idSucursal);
    SucursalDTO getOneSucursal (String nombreSucursal);
    List<SucursalDTO> getAllSucursales();
    SucursalDTO updateSucural(int id, SucursalDTO sucursalDTO);
    void deleteById(Integer idSucursal);
    void deleteByNombre (String nombreSucursal);
}
