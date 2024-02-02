package cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruta")
public class FrutaController {
    @Autowired//Genera una instancia.
    private FrutaService frutaService;

    //Si la fruta existe agrega los kilos directamente.
    @PostMapping("/add")
    public ResponseEntity<?> addFruta (@RequestBody Fruta fruta){

        try {
            Fruta frutaAgregada = frutaService.addfruta(fruta);
            return new ResponseEntity<>(frutaAgregada, HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>("Error al crear la fruta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFrutabyId (@PathVariable int id){
        Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(id);

        if(frutaBuscada.isEmpty())
            return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);
        else {
            return new ResponseEntity<>(frutaBuscada,HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFruta() {
        List<Fruta> frutas = frutaService.getAllFruta();

        if(frutas.isEmpty()){
            return new ResponseEntity<>("No hay frutas disponibles.",HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(frutas, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFruta(@PathVariable int id, @RequestBody Fruta nuevaFruta) {
        Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(id);

        if(frutaBuscada.isEmpty())
            return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);
        else {
            Fruta frutaUpdate = frutaService.updateFruta(id, nuevaFruta.getNombre(), nuevaFruta.getCantidadKilos());
            return new ResponseEntity<>(frutaUpdate,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruta(@PathVariable int id) {
        Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(id);

        if(frutaBuscada.isEmpty())
            return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);

        else {
            frutaService.deleteFrutabyId(id);
            return new ResponseEntity<>("Fruta borrada con éxito.",HttpStatus.OK);
        }
    }

}
