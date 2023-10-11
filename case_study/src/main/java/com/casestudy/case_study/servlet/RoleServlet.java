package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Role;
import com.casestudy.case_study.service.IRoleService;
import com.casestudy.case_study.service.impl.RoleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoleServlet", value = "/roles")
public class RoleServlet extends HttpServlet {
private final IRoleService roleService = new RoleService();
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
                listRole(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void listRole(HttpServletRequest request, HttpServletResponse response) {
        List<Role> roles = roleService.findAll();

        try {
            request.setAttribute("roleList",roles);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/roles/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
