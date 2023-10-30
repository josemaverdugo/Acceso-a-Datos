package Prueba2.Prueba2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name="alumno")

public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int id;
    String nombre;
    String apellido;
    int edad;
    String dni;
    
}
