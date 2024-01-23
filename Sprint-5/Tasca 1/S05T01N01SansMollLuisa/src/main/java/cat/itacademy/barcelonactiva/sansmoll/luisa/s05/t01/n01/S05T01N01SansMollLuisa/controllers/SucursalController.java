package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.controllers;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.services.SucursalServicio;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;


@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalServicio sucursalService;

    @PostMapping("/add")
    public ResponseEntity<?> addSucursal (@RequestBody SucursalDTO sucursalDTO){

        try {
            SucursalDTO sucursalagregada = sucursalService.addSucursal(sucursalDTO);
            return new ResponseEntity<>(sucursalagregada, HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>("Error al crear la sucursal.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneSucursal (@PathVariable int id){
            SucursalDTO sucursalBuscada = sucursalService.getOneSucursal(id);

            if (sucursalBuscada == null) {
                return new ResponseEntity<>("Sucursal no encontrada.", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(sucursalBuscada, HttpStatus.OK);
            }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSucursales () {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursales();

        if(sucursales.isEmpty()){
            return new ResponseEntity<>("No hay sucursales.",HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(sucursales, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSucursal (@PathVariable int id, @RequestBody SucursalDTO nuevasucursalDTO) {
        SucursalDTO sucursalBuscada = sucursalService.getOneSucursal(id);

        if(sucursalBuscada == null) {
            return new ResponseEntity<>("Sucursal no encontrada con el id " + id, HttpStatus.NOT_FOUND);
        }else {
            SucursalDTO sucursalUpdate = sucursalService.updateSucural(id, nuevasucursalDTO);
            return new ResponseEntity<>(sucursalUpdate,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSucursal (@PathVariable int id){
        SucursalDTO sucursalBuscada = sucursalService.getOneSucursal(id);

        if(sucursalBuscada == null){
            return new ResponseEntity<> ("Sucursal no encontrada.", HttpStatus.NOT_FOUND);
        } else {
            sucursalService.deleteById(id);
            return new ResponseEntity<>("Sucursal eliminada.", HttpStatus.OK);
        }
    }
}
