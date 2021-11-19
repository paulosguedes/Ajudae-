package br.com.Badrequest.ajudae.api.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public BaseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public T findById(ID id) {
        String message = String.format("Resource id %s not found", id);
        return this.repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(message));
    }

    @Override
    public T create(T t) {
        return this.repository.save(t);
    }

    @Override
    public T update(T t) {
        return this.repository.save(t);
    }

    @Override
    public void delete(T t) {
        this.repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        T t = this.findById(id);
        this.repository.delete(t);
    }
}
