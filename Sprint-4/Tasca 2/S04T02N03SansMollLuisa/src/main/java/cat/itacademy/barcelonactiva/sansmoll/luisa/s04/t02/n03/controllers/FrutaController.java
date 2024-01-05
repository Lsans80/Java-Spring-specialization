package cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.domain.Fruta;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.services.FrutaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

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
    public ResponseEntity<?> getFrutabyId (@PathVariable String id){
        try {
            ObjectId objectId = new ObjectId(id);
            Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(objectId);

            if (frutaBuscada.isEmpty()) {
                return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<>(frutaBuscada.get(), HttpStatus.OK);
            }

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Formato de ID no válido", HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<?> updateFruta(@PathVariable String id, @RequestBody Fruta nuevaFruta) {

        try {
            ObjectId objectId = new ObjectId(id);
            Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(objectId);

            if (frutaBuscada.isEmpty()) {
                return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);
            } else {
                Fruta frutaUpdate = frutaService.updateFruta(objectId, nuevaFruta.getNombre(), nuevaFruta.getCantidadKilos());
                return new ResponseEntity<>(frutaUpdate, HttpStatus.OK);
            }

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Formato de ID no válido", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruta(@PathVariable ObjectId id) {
        Optional<Fruta> frutaBuscada = frutaService.getFrutabyId(id);

        if(frutaBuscada.isEmpty())
            return new ResponseEntity<>("Fruta no encontrada con el id " + id, HttpStatus.NOT_FOUND);

        else {
            frutaService.deleteFrutabyId(id);
            return new ResponseEntity<>("Fruta borrada con éxito.",HttpStatus.OK);
        }
    }
}
