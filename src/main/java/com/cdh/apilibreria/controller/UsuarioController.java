package com.cdh.apilibreria.controller;

import com.cdh.apilibreria.http.Response;
import com.cdh.apilibreria.model.DTO.UsuarioLoginDTO;
import com.cdh.apilibreria.model.DTO.UsuarioRegisterDTO;
import com.cdh.apilibreria.model.Usuario;
import com.cdh.apilibreria.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("api/usuarios/login")
    public ResponseEntity<Response<String>> saveUsuario(@RequestBody UsuarioLoginDTO usuarioDTO) {
        return usuarioService.login(usuarioDTO);
    }

    @PostMapping("api/usuarios")
    public ResponseEntity<Response<String>> saveUsuario(@RequestBody UsuarioRegisterDTO usuarioDTO) {
        return usuarioService.register(usuarioDTO);
    }

    @GetMapping("api/usuarios/{username}")
    public Usuario getUsuarios(@PathVariable String username) {
        return usuarioService.findByUsername(username);
    }
}
