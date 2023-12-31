package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Employee;
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
                showFormUpdate(request,response);
                break;
            case "remove":
                remove(request,response);
                break;
            default:
                listEmployee(request, response);
        }
    }


    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employees/update.jsp");
        Long id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("employeeList",employeeService.findById(id));
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("departmentList",departmentService.findAll());
        request.setAttribute("educationDegreeList",educationDegreeService.findAll());
        request.setAttribute("userList",userService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
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
    private void remove(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        employeeService.remove(id);
        request.setAttribute("employeeList",employeeService.findAll());

        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                addNewEmployee(request,response);
                break;
            case "update":
                updateEmployee(request,response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Long position_id = Long.valueOf(request.getParameter("position_id"));
        Long department_id = Long.valueOf(request.getParameter("department_id"));
        Long education_degree_id = Long.valueOf(request.getParameter("education_degree_id"));
        Long user_id = Long.valueOf(request.getParameter("user_id"));
        Employee employee = new Employee(id,name,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id);

        boolean check = employeeService.update(employee);
        String mess = "update success";
        if (!check) {
            mess = "Update booking failed.";
        } else {
            request.setAttribute("mess", mess);
            request.setAttribute("check", check);
            try {
                response.sendRedirect(request.getContextPath() + "/employees?action=list");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Long position_id = Long.valueOf(request.getParameter("position_id"));
        Long department_id = Long.valueOf(request.getParameter("department_id"));
        Long education_degree_id = Long.valueOf(request.getParameter("education_degree_id"));
        Long user_id = Long.valueOf(request.getParameter("user_id"));
        Employee employee = new Employee(name,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id);

        boolean check = employeeService.add(employee);
        String mess = "update success";
        if (!check) {
            mess = "Update booking failed.";
        } else {
            request.setAttribute("mess", mess);
            request.setAttribute("check", check);
            try {
                response.sendRedirect(request.getContextPath() + "/employees?action=list");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
