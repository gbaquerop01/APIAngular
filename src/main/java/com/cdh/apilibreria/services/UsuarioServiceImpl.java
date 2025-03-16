package com.cdh.apilibreria.services;

import com.cdh.apilibreria.http.Response;
import com.cdh.apilibreria.model.DTO.UsuarioLoginDTO;
import com.cdh.apilibreria.model.DTO.UsuarioRegisterDTO;
import com.cdh.apilibreria.model.Usuario;
import com.cdh.apilibreria.model.mappers.UsuarioMapper;
import com.cdh.apilibreria.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ResponseEntity<Response<String>> login(UsuarioLoginDTO usuarioDTO) {
        Usuario byUsername = usuarioRepository.findByUsername(usuarioDTO.username());
        if (byUsername.getPassword().equals(usuarioDTO.password())) {
            return ResponseEntity.ok(new Response<String>(HttpStatus.OK, "Login correcto"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity<Response<String>> register(UsuarioRegisterDTO usuarioDTO) {
        if (Objects.equals(usuarioDTO.password(), usuarioDTO.confirmPassword())) {
            usuarioRepository.save(new UsuarioMapper().mapToEntity(usuarioDTO));
            return ResponseEntity.ok(new Response<String>(HttpStatus.OK, "Register correcto"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
