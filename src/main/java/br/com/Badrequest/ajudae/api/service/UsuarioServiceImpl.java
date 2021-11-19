package br.com.Badrequest.ajudae.api.service;

import br.com.Badrequest.ajudae.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    public UsuarioServiceImpl(JpaRepository<Usuario, Long> repository) {
        super(repository);
    }

}
