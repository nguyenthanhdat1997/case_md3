package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IEducationDegreeDAO;
import com.casestudy.case_study.DAO.impl.EducationDegreeDAO;
import com.casestudy.case_study.model.EducationDegree;
import com.casestudy.case_study.service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private final IEducationDegreeDAO educationDegreeDAO = new EducationDegreeDAO();
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeDAO.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return null;
    }

    @Override
    public boolean add(EducationDegree object) {
        return false;
    }

    @Override
    public boolean update(EducationDegree object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
