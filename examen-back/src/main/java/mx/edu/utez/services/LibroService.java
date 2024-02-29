package mx.edu.utez.services;


import mx.edu.utez.models.Libro;
import mx.edu.utez.models.RepositoryLibro;
import mx.edu.utez.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    RepositoryLibro repositoryLibro;

    public Response<List<Libro>> getll(){
        return new Response<>(
                this.repositoryLibro.findAll(),
                false,
                200,
                "Libros Encontrados"
        );
    }
    public Response<List<Libro>> getllFechas(){
        return new Response<>(
                this.repositoryLibro.findAllByOrderByFechaAsc(),
                false,
                200,
                "Libros Encontrados por fechas"
        );
    }
    public Response<List<Libro>> getByAutores(){
        return new Response<>(
                this.repositoryLibro.findAllByOrderByAutorAsc(),
                false,
                200,
                "Libros Encontrados por fechas"
        );
    }
    public Response<List<Libro>> getByImages(){
        return new Response<>(
                this.repositoryLibro.findLibrosByImageIsNotNull(),
                false,
                200,
                "Libros Encontrados por Imagenes"
        );
    }

    public Response<Libro> insert(Libro libro){
        return new Response<>(
                this.repositoryLibro.saveAndFlush(libro),
                false,
                200,
                "Libro ingresado Correctamente"
        );
    }

    public Response<Libro> update(Libro libro){
        return new Response<>(
                this.repositoryLibro.saveAndFlush(libro),
                false,
                200,
                "Libros Actulizado"
        );
    }

    public Response<Void> delete(Long id){
        this.repositoryLibro.deleteById(id);
        return new Response<>(
                null,
                false,
                200,
                "Libro borrado"
        );
    }



}
