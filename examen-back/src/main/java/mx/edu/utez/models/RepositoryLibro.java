package mx.edu.utez.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryLibro extends JpaRepository<Libro,Long> {

    public void deleteById(Long id);
    List<Libro> findAllByOrderByFechaAsc();

    List<Libro> findAllByOrderByAutorAsc();



    List<Libro> findLibrosByImageIsNotNull();





}
