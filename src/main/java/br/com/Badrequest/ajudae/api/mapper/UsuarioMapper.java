package br.com.Badrequest.ajudae.api.mapper;

import br.com.Badrequest.ajudae.api.dto.CreateUsuario;
import br.com.Badrequest.ajudae.api.dto.UsuarioDto;
import br.com.Badrequest.ajudae.api.model.Usuario;
import br.com.Badrequest.ajudae.api.service.OngService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario convertToEntity(CreateUsuario dto){
        return this.modelMapper
                .typeMap(CreateUsuario.class, Usuario.class)
                .map(dto);
    }

    public UsuarioDto convertToDto(Usuario entity){
        return this.modelMapper
                .typeMap(Usuario.class, UsuarioDto.class)
                .map(entity);
    }
}
