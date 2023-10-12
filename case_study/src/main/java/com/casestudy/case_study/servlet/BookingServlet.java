package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.Booking;
import com.casestudy.case_study.service.IBookingService;
import com.casestudy.case_study.service.ICustomerService;
import com.casestudy.case_study.service.IEmployeeService;
import com.casestudy.case_study.service.IPositionService;
import com.casestudy.case_study.service.impl.BookingService;
import com.casestudy.case_study.service.impl.CustomerService;
import com.casestudy.case_study.service.impl.EmployeeService;
import com.casestudy.case_study.service.impl.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookingServlet", value = "/bookings")
public class BookingServlet extends HttpServlet {

    private final IBookingService bookingService = new BookingService();
    private final ICustomerService customerService = new CustomerService();
    private final IEmployeeService employeeService = new EmployeeService();
    private final IPositionService positionService = new PositionService();


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
                listBooking(request,response);
        }
    }

    private void listBooking(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("bookingList",bookingService.findAll());
            request.setAttribute("customerList",customerService.findAll());
            request.setAttribute("employeeList",employeeService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/bookings/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/bookings/create.jsp");
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("bookingList", bookingService.findAll());

        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("bookingList",bookingService.findById(id));
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("employeeList",employeeService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/bookings/update.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void remove(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        bookingService.remove(id);
        request.setAttribute("bookingList",bookingService.findAll());

        try {
            response.sendRedirect("/bookings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                addNewBooking(request,response);
                break;
            case "update":
                updateBooking(request,response);
                break;
        }
    }



    private void addNewBooking(HttpServletRequest request, HttpServletResponse response) {
        String book_time = request.getParameter("book_time");
        String status = request.getParameter("status");
        Long customer_id = Long.valueOf(request.getParameter("customer_id"));
        Long employee_id = Long.valueOf(request.getParameter("employee_id"));

        Booking booking = new Booking(book_time,status,customer_id,employee_id);
        boolean check = bookingService.add(booking);
        String mess = "Thêm thành công";
        if (!check) {
            mess = "fail";
        }else {
            request.setAttribute("mess",mess);
            try {
                response.sendRedirect(request.getContextPath() + "/bookings?action=list");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        String book_time = request.getParameter("book_time");
        String status = request.getParameter("status");
        Long customer_id = Long.valueOf(request.getParameter("customer_id"));
        Long employee_id = Long.valueOf(request.getParameter("employee_id"));
        Booking booking = new Booking(id, book_time, status, customer_id, employee_id);
        boolean check = bookingService.update(booking);

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
