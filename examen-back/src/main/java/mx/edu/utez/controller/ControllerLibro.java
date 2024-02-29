package mx.edu.utez.controller;

import jakarta.validation.Valid;
import mx.edu.utez.models.Libro;
import mx.edu.utez.services.LibroService;
import mx.edu.utez.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/libros/libro")
@CrossOrigin(origins = {"*"})
public class ControllerLibro {
    @Autowired
    LibroService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Libro>>> getAll( ){
        return  new ResponseEntity<>(
                this.service.getll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/fechas/")
    public ResponseEntity<Response<List<Libro>>> getAllfechas( ){
        return  new ResponseEntity<>(
                this.service.getllFechas(),
                HttpStatus.OK
        );
    }
    @GetMapping("/autores/")
    public ResponseEntity<Response<List<Libro>>> getByAutores( ){
        return  new ResponseEntity<>(
                this.service.getByAutores(),
                HttpStatus.OK
        );
    }
    @GetMapping("/images/")
    public ResponseEntity<Response<List<Libro>>> getByImages( ){
        return  new ResponseEntity<>(
                this.service.getByImages(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Libro>> insert(@Valid @RequestBody Libro libro,
                                                  @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.service.insert(libro),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Libro>> update(@Valid @RequestBody Libro libro,
                                                  @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.service.update(libro),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@Valid @PathVariable Long id){
        return  new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
