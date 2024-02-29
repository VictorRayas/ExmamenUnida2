package mx.edu.utez.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    String nombre ;
    String autor;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    String image ;
}
