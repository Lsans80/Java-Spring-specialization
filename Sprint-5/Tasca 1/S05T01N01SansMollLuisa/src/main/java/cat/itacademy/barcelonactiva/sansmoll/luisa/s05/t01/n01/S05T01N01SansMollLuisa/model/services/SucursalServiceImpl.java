package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalServicio{
    @Autowired
    private SucursalRepository sucursalRepository;
    @Override
    public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {

        if(sucursalRepository.existsByNombreSucursalAndPaisSucursal(sucursalDTO.getNombreSucursal(), sucursalDTO.getPaisSucursal())){
            throw new RuntimeException("Ya existe una sucursal con el mismo nombre y país.");

        } else {
            Sucursal sucursal = DTOtoEntity(sucursalDTO);
            sucursal = sucursalRepository.save(sucursal);
            return EntitytoDTO(sucursal);
        }
    }

    @Override
    public SucursalDTO getOneSucursal(Integer idSucursal) {
        Sucursal sucursalBuscada = sucursalRepository.findById(idSucursal).orElse(null);
        return (sucursalBuscada != null) ? EntitytoDTO(sucursalBuscada) : null;
    }

    @Override
    public SucursalDTO getOneSucursal(String nombreSucursal) {
        Sucursal sucursal = sucursalRepository.findByNombreSucursal(nombreSucursal);
        return (sucursal != null) ? EntitytoDTO(sucursal) : null;
    }

    @Override
    public List<SucursalDTO> getAllSucursales() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        return sucursales.stream()
                .map(SucursalServiceImpl::EntitytoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SucursalDTO updateSucural(int id, SucursalDTO sucursalDTO) {
        Sucursal nuevaSucursal = DTOtoEntity(sucursalDTO);
        Optional<Sucursal> sucursalBuscada = sucursalRepository.findById(id);

        if(sucursalBuscada.isPresent()){
            Sucursal sucursal = sucursalBuscada.get();
            sucursal.setNombreSucursal(nuevaSucursal.getNombreSucursal());
            sucursal.setPaisSucursal(nuevaSucursal.getPaisSucursal());
            sucursalRepository.save(sucursal);
            return EntitytoDTO(sucursal);

        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public void deleteByNombre(String nombre) {
        sucursalRepository.deleteByNombreSucursal(nombre);
    }

    private static Sucursal DTOtoEntity(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        return sucursal;
    }

    private static SucursalDTO EntitytoDTO (Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipoSucursal(sucursalDTO.validarTipoSucursal());
        return sucursalDTO;
    }
}
