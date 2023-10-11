package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Department;
import com.casestudy.case_study.service.IDepartmentService;
import com.casestudy.case_study.service.impl.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/departments")
public class DepartmentServlet extends HttpServlet {
    private final IDepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                listDepartment(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listDepartment(HttpServletRequest request, HttpServletResponse response) {
        List<Department> departments = departmentService.findAll();

        try {
            request.setAttribute("departmentList",departments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/departments/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
