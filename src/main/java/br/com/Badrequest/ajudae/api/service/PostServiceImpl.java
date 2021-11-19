package br.com.Badrequest.ajudae.api.service;

import br.com.Badrequest.ajudae.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseServiceImpl<Post, Long> implements PostService {

    public PostServiceImpl(JpaRepository<Post, Long> repository) {
        super(repository);
    }

}
