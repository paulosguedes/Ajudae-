package br.com.Badrequest.ajudae.api.repository;

import br.com.Badrequest.ajudae.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
