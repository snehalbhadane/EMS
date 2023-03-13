package com.yash.ems.onboard.service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BasicService <T, ID> {
    T get(ID id);

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> getAll();
}

