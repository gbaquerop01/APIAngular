package com.cdh.apilibreria.repository;

import com.cdh.apilibreria.model.Usuario;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(@NonNull String username);
}
