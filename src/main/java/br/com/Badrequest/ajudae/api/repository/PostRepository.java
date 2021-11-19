package br.com.Badrequest.ajudae.api.repository;

import br.com.Badrequest.ajudae.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
