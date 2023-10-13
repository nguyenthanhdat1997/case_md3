package com.casestudy.case_study.servlet;

import com.casestudy.case_study.service.IDepartmentService;
import com.casestudy.case_study.service.IEducationDegreeService;
import com.casestudy.case_study.service.IEmployeeService;
import com.casestudy.case_study.service.IPositionService;
import com.casestudy.case_study.service.IUserService;
import com.casestudy.case_study.service.impl.DepartmentService;
import com.casestudy.case_study.service.impl.EducationDegreeService;
import com.casestudy.case_study.service.impl.EmployeeService;
import com.casestudy.case_study.service.impl.PositionService;
import com.casestudy.case_study.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/employees")

public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    IPositionService positionService = new PositionService();
    IDepartmentService departmentService = new DepartmentService();
    IEducationDegreeService educationDegreeService = new EducationDegreeService();
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAdd(request,response);
                break;
            case "update":
                break;
            case "remove":
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employees/create.jsp");
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("departmentList",departmentService.findAll());
        request.setAttribute("educationDegreeList",educationDegreeService.findAll());
        request.setAttribute("userList",userService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setAttribute("employeeList",employeeService.findAll());
            request.setAttribute("positionList",positionService.findAll());
            request.setAttribute("departmentList",departmentService.findAll());
            request.setAttribute("educationDegreeList",educationDegreeService.findAll());
            request.setAttribute("userList",userService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/employees/list.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
