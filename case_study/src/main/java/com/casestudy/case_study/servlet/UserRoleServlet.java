package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Role;
import com.casestudy.case_study.model.User;
import com.casestudy.case_study.model.UserRole;
import com.casestudy.case_study.service.IRoleService;
import com.casestudy.case_study.service.IUserRoleService;
import com.casestudy.case_study.service.IUserService;
import com.casestudy.case_study.service.impl.RoleService;
import com.casestudy.case_study.service.impl.UserRoleService;
import com.casestudy.case_study.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserRoleServlet", value = "/userRoles")
public class UserRoleServlet extends HttpServlet {
private final IUserRoleService userRoleService = new UserRoleService();
private final IUserService userService = new UserService();
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
                listUserRole(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listUserRole(HttpServletRequest request, HttpServletResponse response) {
        List<UserRole> userRoles = userRoleService.findAll();
        List<User> users = userService.findAll();
        List<Role> roles = roleService.findAll();

        try {
            request.setAttribute("userRoleList",userRoles);
            request.setAttribute("userList",users);
            request.setAttribute("roleList",roles);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userRoles/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
