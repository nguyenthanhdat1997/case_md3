package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Employee;
import com.casestudy.case_study.service.IEmployeeService;
import com.casestudy.case_study.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")

public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listEmployee(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.findAll();

        try {
            request.setAttribute("employeeList", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employees/list.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
