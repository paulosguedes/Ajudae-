package br.com.Badrequest.ajudae.api.controller;

import br.com.Badrequest.ajudae.api.dto.CreateUsuario;
import br.com.Badrequest.ajudae.api.dto.UsuarioDto;
import br.com.Badrequest.ajudae.api.mapper.UsuarioMapper;
import br.com.Badrequest.ajudae.api.model.Usuario;
import br.com.Badrequest.ajudae.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll(){
        List<UsuarioDto> usuarios = this.usuarioService.findAll()
                .stream()
                .map(this.usuarioMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id){
        Usuario usuario = this.usuarioService.findById(id);
        return new ResponseEntity<>(this.usuarioMapper.convertToDto(usuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody CreateUsuario dto){
        Usuario usuario = this.usuarioService.create(this.usuarioMapper.convertToEntity(dto));
        return new ResponseEntity<>(this.usuarioMapper.convertToDto(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto dto){
        Usuario usuario = this.usuarioService.findById(id);
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setEndereco(dto.getEndereco());
        usuario.setTelefone(dto.getTelefone());
        return new ResponseEntity<>(this.usuarioMapper.convertToDto(this.usuarioService.update(usuario)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Usuario usuario = this.usuarioService.findById(id);
        this.usuarioService.delete(usuario);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
