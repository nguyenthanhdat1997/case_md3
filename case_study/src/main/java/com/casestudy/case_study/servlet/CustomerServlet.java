package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.model.CustomerType;
import com.casestudy.case_study.model.User;
import com.casestudy.case_study.service.ICustomerService;
import com.casestudy.case_study.service.ICustomerTypeService;
import com.casestudy.case_study.service.IUserService;
import com.casestudy.case_study.service.impl.CustomerService;
import com.casestudy.case_study.service.impl.CustomerTypeService;
import com.casestudy.case_study.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet{
    private final ICustomerService customerService = new CustomerService();
    private final ICustomerTypeService customerTypeService = new CustomerTypeService();
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
            case "edit":
                break;
            case "delete":
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.findAll();
        List<CustomerType> customerTypes = customerTypeService.findAll();
        List<User> users = userService.findAll();

        try {
            request.setAttribute("customerList",customers);
            request.setAttribute("customerTypeList",customerTypes);
            request.setAttribute("userList",users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customers/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
