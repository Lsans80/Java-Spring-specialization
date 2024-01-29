package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.dto.FlorDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FlorService {

    FlorDTO addFlor (FlorDTO florDTO);
    FlorDTO getOneFlor (int idFlorDTO);
    FlorDTO getOneFlor (String nombreFlor);
    List<FlorDTO> getAllFlores();
    FlorDTO updateFlor(int id, FlorDTO florDTO);
    void deleteById(int idFlor);
    void deleteByNombre (String nombreFlor);

}
