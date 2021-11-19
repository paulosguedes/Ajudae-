package br.com.Badrequest.ajudae.api.controller;

import br.com.Badrequest.ajudae.api.dto.CreateOng;
import br.com.Badrequest.ajudae.api.dto.OngDto;
import br.com.Badrequest.ajudae.api.mapper.OngMapper;
import br.com.Badrequest.ajudae.api.model.Ong;
import br.com.Badrequest.ajudae.api.service.OngService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ong")
public class OngController {

    private final OngService ongService;
    private final OngMapper ongMapper;

    public OngController(OngService ongService, OngMapper ongMapper) {
        this.ongService = ongService;
        this.ongMapper = ongMapper;
    }

    @GetMapping
    public ResponseEntity<List<OngDto>> findAll(){
        List<OngDto> ongs = this.ongService.findAll()
                .stream()
                .map(this.ongMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(ongs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OngDto> findById(@PathVariable Long id){
        Ong ong = this.ongService.findById(id);
        return new ResponseEntity<>(this.ongMapper.convertToDto(ong), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OngDto> create(@RequestBody CreateOng dto){
        Ong ong = this.ongService.create(this.ongMapper.convertToEntity(dto));
        return new ResponseEntity<>(this.ongMapper.convertToDto(ong), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OngDto> update(@PathVariable Long id, @RequestBody OngDto dto){
        Ong ong = this.ongService.findById(id);
        ong.setNome(dto.getNome());
        ong.setCnpj(dto.getCnpj());
        ong.setEmail(dto.getEmail());
        ong.setEndereco(dto.getEndereco());
        ong.setTelefone(dto.getTelefone());
        return new ResponseEntity<>(this.ongMapper.convertToDto(this.ongService.update(ong)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Ong ong = this.ongService.findById(id);
        this.ongService.delete(ong);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
