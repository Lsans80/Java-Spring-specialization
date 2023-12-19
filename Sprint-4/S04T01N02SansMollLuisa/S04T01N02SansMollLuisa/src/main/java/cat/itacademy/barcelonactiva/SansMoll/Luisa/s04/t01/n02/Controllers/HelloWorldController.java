package cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t01.n02.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //http://localhost:9001/HelloWorld
    //http://localhost:9001/HelloWorld?nombre=Luisa

    @GetMapping ("/HelloWorld")
    public String saluda (@RequestParam(defaultValue = "UNKNOWN") String nombre){

        return "Hola " +nombre+ ". Estás ejecutando un proyecto Gradle.";
    }

    //http://localhost:9001/HelloWorld2
    //http://localhost:9001/HelloWorld2/Luisa
    @GetMapping (value = {"/HelloWorld2", "/HelloWorld2/{nombre}"})
    public String saluda2 (@PathVariable (required = false) String nombre){

        if (nombre == null) {
            nombre = "UNKNOWN";
        }
        return "Hola " + nombre + ". Estás ejecutando un projecte Gradle.";
    }

}
