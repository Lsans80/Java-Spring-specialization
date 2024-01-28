package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    private FlorService florService;

    @Operation(summary = "Only nombreFlor and paisFlor requested. pk_FlorID and tipoFlor are generated automatically.")
    @PostMapping("/add")
    public ResponseEntity<?> addFlor (@RequestBody FlorDTO florDTO){

        try{
            FlorDTO florAgregada = florService.addFlor(florDTO);
            return new ResponseEntity<>(florAgregada, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Error al crear la flor." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity <?> getOneFlor (@PathVariable int id){
        FlorDTO florBuscada = florService.getOneFlor(id);
        if(florBuscada == null){
            return new ResponseEntity<>("Flor no encontrada.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(florBuscada, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlores() {
        List<FlorDTO> flores = florService.getAllFlores();

        if(flores.isEmpty()){
            return new ResponseEntity<>("No hay flores.",HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(flores, HttpStatus.OK);
        }
    }

    @Operation(summary = "Only nombreFlor and paisFlor requested. pk_FlorID and tipoFlor are generated automatically.")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFlor (@PathVariable int id, @RequestBody FlorDTO nuevaFlorDTO) {
        FlorDTO florBuscada = florService.getOneFlor(id);

        if(florBuscada == null) {
            return new ResponseEntity<>("Flor no encontrada con el id " + id, HttpStatus.NOT_FOUND);
        }else {
            FlorDTO florUpdate = florService.updateFlor(id, nuevaFlorDTO);
            return new ResponseEntity<>(florUpdate,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSucursal (@PathVariable int id){
        FlorDTO sucursalBuscada = florService.getOneFlor(id);

        if(sucursalBuscada == null){
            return new ResponseEntity<> ("Flor no encontrada.", HttpStatus.NOT_FOUND);
        } else {
            florService.deleteById(id);
            return new ResponseEntity<>("Flor eliminada.", HttpStatus.OK);
        }
    }
}

