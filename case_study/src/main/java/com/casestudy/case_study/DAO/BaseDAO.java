package com.casestudy.case_study.DAO;

import com.casestudy.case_study.model.Customer;

import java.util.List;

public interface BaseDAO<E> {
    List<E> findAll();
    E findById(Long id);
    boolean add(E object);
    boolean update(E object);
    boolean remove(Long id);
}
