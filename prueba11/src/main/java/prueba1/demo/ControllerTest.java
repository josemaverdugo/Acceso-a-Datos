/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joses
 */
@Controller()
public class ControllerTest {
    @GetMapping
    public String pagina(){
        return "paginaPrincipal";
    }
    @GetMapping("/tabla")
    public String tabla(){
    return "tabla";
}

    
    
}
