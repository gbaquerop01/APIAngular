package com.cdh.apilibreria.services;

import com.cdh.apilibreria.model.DTO.FacturaDTO;
import com.cdh.apilibreria.model.Factura;
import com.cdh.apilibreria.model.Libro;
import com.cdh.apilibreria.model.mappers.FacturaMapper;
import com.cdh.apilibreria.repository.FacturasRepository;
import com.cdh.apilibreria.repository.LibroRepository;
import com.cdh.apilibreria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturasServiceImpl implements FacturasService {
    private final LibroRepository libroRepository;
    private FacturasRepository facturasRepository;
    private UsuarioRepository usuarioRepository;


    public FacturasServiceImpl(FacturasRepository facturasRepository, UsuarioRepository usuarioRepository, LibroRepository libroRepository) {
        this.facturasRepository = facturasRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public FacturaDTO listarFacturas(FacturaDTO facturaDTO) {
        System.out.println("Listando mierda esta");
        Factura factura = new FacturaMapper().mapToEntity(facturaDTO);

        facturaDTO.libros().forEach(libro -> {
            Libro libroByISBN = libroRepository.findLibroByISBN(libro.getISBN());
            factura.addLibro(libroByISBN);
        });

        factura.setUsuario(usuarioRepository.findByUsername(facturaDTO.usuario()));
        facturasRepository.save(factura);
        return facturaDTO;
    }
}
