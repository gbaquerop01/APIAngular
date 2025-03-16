package com.cdh.apilibreria.services;

import com.cdh.apilibreria.model.DTO.FacturaDTO;
import com.cdh.apilibreria.model.Factura;
import com.cdh.apilibreria.model.mappers.FacturaMapper;
import com.cdh.apilibreria.repository.FacturasRepository;
import com.cdh.apilibreria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturasServiceImpl implements FacturasService {
    private FacturasRepository facturasRepository;
    private UsuarioRepository usuarioRepository;

    public FacturasServiceImpl(FacturasRepository facturasRepository, UsuarioRepository usuarioRepository) {
        this.facturasRepository = facturasRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public FacturaDTO listarFacturas(FacturaDTO facturaDTO) {
        Factura factura = new FacturaMapper().mapToEntity(facturaDTO);
        factura.setUsuario(usuarioRepository.findByUsername(facturaDTO.usuario()));
        facturasRepository.save(factura);
        return facturaDTO;
    }
}
