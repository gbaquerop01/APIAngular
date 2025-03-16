package com.cdh.apilibreria.controller;

import com.cdh.apilibreria.model.Libro;
import com.cdh.apilibreria.repository.LibroRepository;
import com.cdh.apilibreria.unimplemented.controller.GenericController;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Prueba

@CrossOrigin(origins = "*")
@Controller
public class LibrosController implements GenericController<Libro, String> {

    @Autowired
    private LibroRepository libroRepository;

    @RequestMapping(path = "/api/libros", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ResponseEntity<List<Libro>> get() {
        return ResponseEntity.ok(libroRepository.findAll());

    }


    @RequestMapping(path = "/api/libros", method = RequestMethod.POST)
    @Override
    public ResponseEntity<Libro> post(@RequestBody Libro libro) {
        if (libroRepository.existsByISBN(libro.getISBN())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @PutMapping(path = "/api/libros")
    @Override
    @Transactional
    public ResponseEntity<Libro> put(@RequestBody Libro libro) {
        if (libroRepository.existsByISBN(libro.getISBN())){
            Libro byISBN = libroRepository.getLibroByISBN(libro.getISBN());
            libro.setId(byISBN.getId());
            libroRepository.save(libro);
            return ResponseEntity.ok(libro);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/api/libros/{ISBN}", method = RequestMethod.DELETE)
    @Override
    @Transactional
    public ResponseEntity<Libro> delete(@PathVariable String ISBN) {
        if (libroRepository.existsByISBN(ISBN)) {
            Libro libro = libroRepository.getLibroByISBN(ISBN);
            libroRepository.delete(libro);
            return ResponseEntity.ok(libro);
        }
        return ResponseEntity.notFound().build();
    }
}
