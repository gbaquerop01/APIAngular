package com.cdh.apilibreria.repository;

import com.cdh.apilibreria.model.Libro;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    boolean existsByISBN(@NonNull String isbn);

    boolean deleteByISBN(@NonNull String isbn);

    Libro getLibroByISBN(@NonNull String isbn);
}
