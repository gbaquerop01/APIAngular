package com.cdh.apilibreria.controller;

import com.cdh.apilibreria.model.DTO.FacturaDTO;
import com.cdh.apilibreria.services.FacturasService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@Controller
public class FacturasController {
    private FacturasService facturasService;

    public FacturasController(FacturasService facturasService) {
        this.facturasService = facturasService;
    }

    @PostMapping("/api/facturas")
    public ResponseEntity<FacturaDTO> listarFacturas(@RequestBody FacturaDTO facturaDTO) {
        return ResponseEntity.ok(facturasService.listarFacturas(facturaDTO));
    }
}
