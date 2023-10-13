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
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
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
                listCustomer(request,response);
                break;
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("customerList",customerService.findById(id));
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        request.setAttribute("userList",userService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customers/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customers/create.jsp");
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        request.setAttribute("userList",userService.findAll());
        request.setAttribute("customerList",customerService.findAll());

        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void remove(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        customerService.remove(id);
        request.setAttribute("customerList", customerService.findAll());
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
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
                addNewCustomer(request,response);
                break;
            case "update":
                updateCustomer(request,response);
                break;
        }
    }



    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerList",customerService.findAll());
            request.setAttribute("customerTypeList",customerTypeService.findAll());
            request.setAttribute("userList",userService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customers/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Long customer_type_id = Long.valueOf(request.getParameter("customer_type_id"));
        Long user_id = Long.valueOf(request.getParameter("user_id"));
        Customer customer = new Customer(name,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id);

        boolean check = customerService.add(customer);
        String mess = "Thêm thành công";
        if (!check){
            mess = "thêm thất bại";
        }else{
            request.setAttribute("mess",mess);
            try {
                response.sendRedirect(request.getContextPath() + "/customers?action=list");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Long customer_type_id = Long.valueOf(request.getParameter("customer_type_id"));
        Long user_id = Long.valueOf(request.getParameter("user_id"));

        Customer customer = new Customer(id,name,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id);
        boolean check = customerService.update(customer);

        String mess = "update success";
        if (!check) {
            mess = "Update booking failed.";
        } else {
            request.setAttribute("mess", mess);
            request.setAttribute("check", check);
            try {
                response.sendRedirect(request.getContextPath() + "/bookings?action=list");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
