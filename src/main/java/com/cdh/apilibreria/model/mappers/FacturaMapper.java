package com.cdh.apilibreria.model.mappers;

import com.cdh.apilibreria.model.DTO.FacturaDTO;
import com.cdh.apilibreria.model.Factura;

import java.time.LocalDate;

public class FacturaMapper implements Mapper<Factura, FacturaDTO> {
    @Override
    public Factura mapToEntity(FacturaDTO dto) {
        Factura factura = new Factura();
        factura.setTotalFactura(dto.precio());
        factura.setLibros(dto.libros());
        factura.setFecha(LocalDate.now());
        return factura;
    }
}
