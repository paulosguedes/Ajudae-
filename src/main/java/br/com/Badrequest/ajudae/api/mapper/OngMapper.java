package br.com.Badrequest.ajudae.api.mapper;

import br.com.Badrequest.ajudae.api.dto.CreateOng;
import br.com.Badrequest.ajudae.api.dto.OngDto;
import br.com.Badrequest.ajudae.api.model.Ong;
import br.com.Badrequest.ajudae.api.service.OngService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OngMapper {

    private final ModelMapper modelMapper;

    public OngMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Ong convertToEntity(CreateOng dto){
        Ong ong = new Ong();
        ong.setNome(dto.getNome());
        ong.setEmail(dto.getEmail());
        ong.setEndereco(dto.getEndereco());
        ong.setCnpj(dto.getCnpj());
        ong.setTelefone(dto.getTelefone());
        return ong;
    }

    public OngDto convertToDto(Ong entity){
        return this.modelMapper
                .typeMap(Ong.class, OngDto.class)
                .map(entity);
    }
}
