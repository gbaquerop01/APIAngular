package com.cdh.apilibreria.repository;

import com.cdh.apilibreria.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturasRepository extends JpaRepository<Factura, Long> {
}
