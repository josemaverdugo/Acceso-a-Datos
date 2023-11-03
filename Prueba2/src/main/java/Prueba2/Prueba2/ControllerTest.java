/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba2.Prueba2;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listaPersonas(Model model, @PageableDefault(size=5)Pageable p ) {
        Page<Alumno> alumnos = alumnorepository.findAll(p);
        model.addAttribute("alumnos", alumnos);
        return "PaginaInicial";
    }
    @GetMapping("/nuevo")
    public String form(Model model){
        model.addAttribute("alumno", new Alumno());
        return "formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        alumnorepository.deleteById(id);
        return "redirect:/Inicio";
    }

    @PostMapping("/editar/" + "{id}")
            public String update(int id, Alumno a) {
    //public String update(@PathVariable int id, @ModelAttribute Alumno alumnoActualizado) {
        Optional<Alumno> alumnoExistente = alumnorepository.findById(id);
        //alumnoExistente.ifPresent(value->alumnorepository.save(value));
        
        if (alumnoExistente.isPresent()) {
            Alumno alumno = alumnoExistente.get();
            alumno.setNombre(a.getNombre());
            alumno.setApellido(a.getApellido());
            alumno.setEdad(a.getEdad());
            alumno.setDni(a.getDni());
            alumnorepository.save(alumno);
        }
        return "redirect:/Inicio";
    }

    @GetMapping("/editar/" + "{id}")
    public String update(@PathVariable Integer id, Model model) {
        Optional<Alumno> alumno = alumnorepository.findById(id);
        model.addAttribute("alumno", alumno);
        return "modificar";
    }
}
