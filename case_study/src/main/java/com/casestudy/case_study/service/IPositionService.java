package com.casestudy.case_study.service;

import com.casestudy.case_study.model.Position;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPositionService extends IUtilService<Position> {
    boolean addPosition(HttpServletRequest request, HttpServletResponse response);
}
