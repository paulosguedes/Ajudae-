package br.com.Badrequest.ajudae.api.service;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> findAll();

    List<T> findAll(Sort sort);

    T findById(ID id);

    T create(T t);

    T update(T t);

    void delete(T t);

    void deleteById(ID id);
}
