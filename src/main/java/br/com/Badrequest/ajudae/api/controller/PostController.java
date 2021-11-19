package br.com.Badrequest.ajudae.api.controller;

import br.com.Badrequest.ajudae.api.dto.CreatePost;
import br.com.Badrequest.ajudae.api.dto.PostDto;
import br.com.Badrequest.ajudae.api.dto.PostRetunDto;
import br.com.Badrequest.ajudae.api.mapper.PostMapper;
import br.com.Badrequest.ajudae.api.model.Ong;
import br.com.Badrequest.ajudae.api.model.Post;
import br.com.Badrequest.ajudae.api.model.Usuario;
import br.com.Badrequest.ajudae.api.service.OngService;
import br.com.Badrequest.ajudae.api.service.PostService;
import br.com.Badrequest.ajudae.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    private final UsuarioService usuarioService;
    private final OngService ongService;
    private final PostMapper postMapper;

    public PostController(PostService postService, UsuarioService usuarioService, OngService ongService, PostMapper postMapper) {
        this.postService = postService;
        this.usuarioService = usuarioService;
        this.ongService = ongService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public ResponseEntity<List<PostRetunDto>> findAll(){
        List<PostDto> posts = this.postService.findAll()
                .stream()
                .map(this.postMapper::convertToDto)
                .collect(Collectors.toList());
        List<PostRetunDto> dtos = new ArrayList<>();
        for (PostDto post : posts) {
            PostRetunDto dto = new PostRetunDto();
            Post postFound = this.postService.findById(post.getId());
            dto.setId(postFound.getId());
            dto.setTitulo(postFound.getTitulo());
            dto.setDescricao(postFound.getDescricao());
            if(post.getTipoUsuario().equalsIgnoreCase("Usuario")){
                Usuario usuario = this.usuarioService.findById(postFound.getId_user());
                dto.setUsuario(usuario);
            }
            else{
                Ong ong = this.ongService.findById(postFound.getId_user());
                dto.setOng(ong);
            }
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostRetunDto> findById(@PathVariable Long id){
        PostRetunDto dto = new PostRetunDto();
        Post post = this.postService.findById(id);
        dto.setId(post.getId());
        dto.setTitulo(post.getTitulo());
        dto.setDescricao(post.getDescricao());
        if(post.getTipoUsuario().equalsIgnoreCase("Usuario")){
            Usuario usuario = this.usuarioService.findById(post.getId_user());
            dto.setUsuario(usuario);
        }
        else{
            Ong ong = this.ongService.findById(post.getId_user());
            dto.setOng(ong);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> create(@RequestBody CreatePost dto){
        Post post = this.postService.create(this.postMapper.convertToEntity(dto));
        return new ResponseEntity<>(this.postMapper.convertToDto(post), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Long id, @RequestBody PostDto dto){
        Post post = this.postService.findById(id);
        post.setDescricao(dto.getDescricao());
        post.setTitulo(dto.getTitulo());
        post.setTipoUsuario(dto.getTipoUsuario());
        post.setId_user(dto.getId_user());
        return new ResponseEntity<>(this.postMapper.convertToDto(this.postService.update(post)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Post post = this.postService.findById(id);
        this.postService.delete(post);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
