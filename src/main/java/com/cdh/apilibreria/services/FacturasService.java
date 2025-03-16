package com.cdh.apilibreria.services;

import com.cdh.apilibreria.model.DTO.FacturaDTO;
import org.springframework.stereotype.Service;

@Service
public interface FacturasService {
    FacturaDTO listarFacturas(FacturaDTO facturaDTO);
}
