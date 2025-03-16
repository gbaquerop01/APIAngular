package com.cdh.apilibreria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private LocalDate fecha;

    @NonNull
    private double totalFactura;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Libro> libros;


}
