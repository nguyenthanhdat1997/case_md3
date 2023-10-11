package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.CustomerType;
import com.casestudy.case_study.service.ICustomerTypeService;
import com.casestudy.case_study.service.impl.CustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerTypeSevlet", value = "/customerTypes")
public class CustomerTypeServlet extends HttpServlet {
private final ICustomerTypeService customerTypeService = new CustomerTypeService();

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
                listCustomerType(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void listCustomerType(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypes = customerTypeService.findAll();

        try {
            request.setAttribute("customerTypeList",customerTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customerTypes/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
