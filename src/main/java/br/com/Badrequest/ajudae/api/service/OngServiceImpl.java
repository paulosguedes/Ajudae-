package br.com.Badrequest.ajudae.api.service;

import br.com.Badrequest.ajudae.api.model.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OngServiceImpl extends BaseServiceImpl<Ong, Long> implements OngService {

    public OngServiceImpl(JpaRepository<Ong, Long> repository) {
        super(repository);
    }

}
