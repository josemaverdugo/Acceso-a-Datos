/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba2.Prueba2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author joses
 */
@Controller
public class ControllerTest {
    @Autowired
    private AlumnoRepository alumnorepository;
    
    @PostMapping("/nuevo")
    public String guardarAlumno(Alumno alumno){
        alumnorepository.save(alumno);
        return "redirect:/Inicio";
    }
    @GetMapping("/Inicio")
    public String listaPersonas(Model model) {
        List<Alumno> alumnos = alumnorepository.findAll();
        model.addAttribute("alumnos", alumnos);
        return "PaginaInicial";
    }
    @GetMapping("/nuevo")
    public String form(Model model){
        model.addAttribute("alumno", new Alumno());
        return "formulario";
    }
}
