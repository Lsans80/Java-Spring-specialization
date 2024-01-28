package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService {

    @Autowired
    private FlorRepository florRepository;


    @Override
    public FlorDTO addFlor(FlorDTO florDTO) {
        if(florRepository.existsByNombreFlorAndPaisFlor(florDTO.getNombreFlor(), florDTO.getPaisFlor())){
            throw new RuntimeException("Ya existe una flor con el mismo nombre y país.");

        } else {
            Flor flor = DTOtoEntity(florDTO);
            flor = florRepository.save(flor);
            return EntitytoDTO(flor);
        }
    }

    @Override
    public FlorDTO getOneFlor(int idFlor) {
        Flor florbuscada = florRepository.findById(idFlor).orElse(null);
        return (florbuscada != null) ? EntitytoDTO(florbuscada) : null;
    }

    @Override
    public FlorDTO getOneFlor(String nombreFlor) {
        Flor florBuscada = florRepository.findByNombreFlor(nombreFlor);
        return (florBuscada != null) ? EntitytoDTO(florBuscada) : null;
    }

    @Override
    public List<FlorDTO> getAllFlores() {
        List<Flor> flores = florRepository.findAll();
        return flores.stream()
                .map(FlorServiceImpl::EntitytoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlorDTO updateFlor(int id, FlorDTO florDTO) {
        Flor nuevaFlor = DTOtoEntity(florDTO);
        Optional<Flor> florbuscada = florRepository.findById(id);

        if(florbuscada.isPresent()){
            Flor flor = florbuscada.get();
            flor.setNombreFlor(nuevaFlor.getNombreFlor());
            flor.setPaisFlor(nuevaFlor.getPaisFlor());
            florRepository.save(flor);
            return EntitytoDTO(flor);

        } else {
            return null;
        }
    }

    @Override
    public void deleteById(int idFlor) {
        florRepository.deleteById(idFlor);
    }

    @Override
    public void deleteByNombre(String nombreFlor) {
        florRepository.deleteByNombreFlor(nombreFlor);
    }

    private static Flor DTOtoEntity(FlorDTO florDTO) {
        Flor flor = new Flor();
        flor.setPk_FlorID(florDTO.getPk_FlorID());
        flor.setNombreFlor(florDTO.getNombreFlor());
        flor.setPaisFlor(florDTO.getPaisFlor());
        return flor;
    }

    private static FlorDTO EntitytoDTO (Flor flor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNombreFlor(flor.getNombreFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        florDTO.setTipoFlor(florDTO.validarTipoFlor());
        return florDTO;
    }
}
