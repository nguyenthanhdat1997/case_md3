package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Admin;
import com.casestudy.case_study.model.User;
import com.casestudy.case_study.service.IAdminService;
import com.casestudy.case_study.service.IUserService;
import com.casestudy.case_study.service.impl.AdminService;
import com.casestudy.case_study.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admins")

public class AdminServlet extends HttpServlet {
    private final IAdminService adminService = new AdminService();
    private final IUserService userService = new UserService();

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
                listAdmin(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listAdmin(HttpServletRequest request, HttpServletResponse response) {
        List<Admin> admins = adminService.findAll();
        List<User> users = userService.findAll();

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admins/list.jsp");
            request.setAttribute("adminList", admins);
            request.setAttribute("userList",users);
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
