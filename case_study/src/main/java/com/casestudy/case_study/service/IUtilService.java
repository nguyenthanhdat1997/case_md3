package com.casestudy.case_study.service;

import com.casestudy.case_study.model.Admin;

import java.util.List;

public interface IUtilService<E> {
    List<E> findAll();
    E findById(Long id);
    boolean save(E object);
    boolean update(E object);
    boolean remove(Long id);
}
