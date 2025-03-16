package com.cdh.apilibreria.services;

import com.cdh.apilibreria.http.Response;
import com.cdh.apilibreria.model.DTO.UsuarioLoginDTO;
import com.cdh.apilibreria.model.DTO.UsuarioRegisterDTO;
import com.cdh.apilibreria.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<Response<String>> login(UsuarioLoginDTO usuarioDTO);

    ResponseEntity<Response<String>> register(UsuarioRegisterDTO usuarioDTO);

    Usuario findByUsername(String username);
}
