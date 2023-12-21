package cat.itacademy.barcelonactiva.sans.luisa.s04.t01.n01.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //http://localhost:9000/HelloWorld
    //http://localhost:9000/HelloWorld?nombre=Luisa

    @GetMapping("/HelloWorld")
    public String saluda (@RequestParam(defaultValue = "UNKNOWN") String nombre){

        return "Hola, " + nombre + ". Estás ejecutando un proyecto Maven";
    }


    //http://localhost:9000/HelloWorld2
    //http://localhost:9000/HelloWorld2/Luisa
    @GetMapping(value = {"/HelloWorld2/{nombre}", "/HelloWorld2"})
    public String saluda2 (@PathVariable(required = false) String nombre){

        if (nombre == null){
            nombre = "Unknown";
        }

        return "Hola, " + nombre + ". Estás ejecutando un proyecto Maven";
    }
}
