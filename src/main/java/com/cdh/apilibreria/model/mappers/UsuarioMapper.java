package com.cdh.apilibreria.model.mappers;

import com.cdh.apilibreria.model.DTO.UsuarioRegisterDTO;
import com.cdh.apilibreria.model.Usuario;
import com.cdh.apilibreria.model.enums.UserRole;

public class UsuarioMapper implements Mapper<Usuario, UsuarioRegisterDTO>{
    @Override
    public Usuario mapToEntity(UsuarioRegisterDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.password());
        usuario.setRole(UserRole.GUEST);
        return usuario;
    }
}
