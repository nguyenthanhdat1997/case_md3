package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IPositionDAO;
import com.casestudy.case_study.DAO.impl.PositionDAO;
import com.casestudy.case_study.model.Position;
import com.casestudy.case_study.service.IPositionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PositionService implements IPositionService {
    private final IPositionDAO positionDAO = new PositionDAO();

    @Override
    public List<Position> findAll() {
        return positionDAO.findAll();
    }

    @Override
    public Position findById(Long id) {
        return null;
    }

    @Override
    public boolean add(Position object) {
        return positionDAO.add(object);
    }

    @Override
    public boolean update(Position object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }


}
