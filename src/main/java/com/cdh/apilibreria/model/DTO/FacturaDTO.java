package com.cdh.apilibreria.model.DTO;

import com.cdh.apilibreria.model.Libro;

import java.util.List;

public record FacturaDTO(double precio, String usuario, List<Libro> libros) {
}
