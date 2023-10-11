package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.User;
import com.casestudy.case_study.service.IUserService;
import com.casestudy.case_study.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",value = "/users")
public class UserServlet extends HttpServlet {
    private final IUserService userService = new UserService();

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
                listUser(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.findAll();

        try {request.setAttribute("userList",users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/users/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
