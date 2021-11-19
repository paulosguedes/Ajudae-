package br.com.Badrequest.ajudae.api.mapper;

import br.com.Badrequest.ajudae.api.dto.CreatePost;
import br.com.Badrequest.ajudae.api.dto.CreateUsuario;
import br.com.Badrequest.ajudae.api.dto.PostDto;
import br.com.Badrequest.ajudae.api.dto.UsuarioDto;
import br.com.Badrequest.ajudae.api.model.Post;
import br.com.Badrequest.ajudae.api.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private final ModelMapper modelMapper;

    public PostMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Post convertToEntity(CreatePost dto){
        return this.modelMapper
                .typeMap(CreatePost.class, Post.class)
                .map(dto);
    }

    public PostDto convertToDto(Post entity){
        return this.modelMapper
                .typeMap(Post.class, PostDto.class)
                .map(entity);
    }


}
