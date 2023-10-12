package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Position;
import com.casestudy.case_study.service.IPositionService;
import com.casestudy.case_study.service.impl.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PositionServlet", value = "/positions")
public class PositionServlet extends HttpServlet {
    private final IPositionService positionService = new PositionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                listPosition(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;

        }
    }

    private void listPosition(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positions = positionService.findAll();

        try {
            request.setAttribute("positionList", positions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/positions/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
