package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.exceptions.FlorAlreadyExists;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.exceptions.FlorNotFound;
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
            throw new FlorAlreadyExists("Ya existe una flor con el mismo nombre y país.");

        } else {
            Flor flor = DTOtoEntity(florDTO);
            flor = florRepository.save(flor);
            return EntitytoDTO(flor);
        }
    }

    @Override
    public FlorDTO getOneFlor(int idFlor) {
        Flor florBuscada = florRepository.findById(idFlor).orElse(null);

        if(florBuscada == null){
            throw new FlorNotFound("No se ha encontrado la flor con el ID "+ idFlor);
        } else {
            return EntitytoDTO(florBuscada);
        }
    }

    @Override
    public FlorDTO getOneFlor(String nombreFlor) {
        Flor florBuscada = florRepository.findByNombreFlor(nombreFlor);

        if(florBuscada == null){
            throw new FlorNotFound("No se ha encontrado la flor con el nombre "+ nombreFlor);
        } else {
            return EntitytoDTO(florBuscada);
        }
    }

    @Override
    public List<FlorDTO> getAllFlores() {
        List<Flor> flores = florRepository.findAll();

        if(flores.isEmpty()){
            throw new FlorNotFound("No se han encontrado flores, la lista esta vacía.");

        } else {
            return flores.stream()
                    .map(FlorServiceImpl::EntitytoDTO)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public FlorDTO updateFlor(int idFlor, FlorDTO florDTO) {
        Flor nuevaFlor = DTOtoEntity(florDTO);
        Optional<Flor> florbuscada = florRepository.findById(idFlor);

        if(florbuscada.isPresent()){
            Flor flor = florbuscada.get();
            flor.setNombreFlor(nuevaFlor.getNombreFlor());
            flor.setPaisFlor(nuevaFlor.getPaisFlor());
            florRepository.save(flor);
            return EntitytoDTO(flor);

        } else {
            throw new FlorNotFound("No se ha encontrado la flor con el ID "+ idFlor);
        }
    }

    @Override
    public void deleteById(int idFlor) {
        Optional<Flor> florbuscada = florRepository.findById(idFlor);

        if(florbuscada.isPresent()){
            florRepository.deleteById(idFlor);
        } else {
            throw new FlorNotFound("No se ha encontrado la flor con el ID "+ idFlor);
        }
    }

    @Override
    public void deleteByNombre(String nombreFlor) {
        Flor florbuscada = florRepository.findByNombreFlor(nombreFlor);

        if(florbuscada == null){
            florRepository.deleteByNombreFlor(nombreFlor);
        } else {
            throw new FlorNotFound("No se ha encontrado la flor con el nombre "+ nombreFlor);
        }
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
