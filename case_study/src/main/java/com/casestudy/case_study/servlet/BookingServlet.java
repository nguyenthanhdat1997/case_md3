package com.casestudy.case_study.servlet;

import com.casestudy.case_study.DAO.impl.BookingDAO;
import com.casestudy.case_study.model.Booking;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.model.Employee;
import com.casestudy.case_study.model.Position;
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
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/bookings")
public class BookingServlet extends HttpServlet {

    private final IBookingService bookingService = new BookingService();
    private final ICustomerService customerService = new CustomerService();
    private final IEmployeeService employeeService = new EmployeeService();
    private final IPositionService positionService = new PositionService();

    private final List<Booking> bookings = bookingService.findAll();
    private final List<Customer> customers = customerService.findAll();
    private final List<Employee> employees = employeeService.findAll();
    private final List<Position> positions = positionService.findAll();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBooking(request,response);
                break;
            case "update":
                updateBooking(request,response);
                break;
            case "delete":
                break;
            default:
                listBooking(request,response);
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
                bookingService.addBooking(request,response);
                break;
            case "update":
                bookingService.updateBooking(request,response);
                break;
        }
    }

    private void listBooking(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("bookingList",bookings);
            request.setAttribute("customerList",customers);
            request.setAttribute("employeeList",employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookings/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void createBooking(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/bookings/create.jsp");
            request.setAttribute("customerList",customers);
            request.setAttribute("bookingList",bookings);
            request.setAttribute("employeeList",employees);
            request.setAttribute("positionList",positions);

            requestDispatcher.forward(request,response);

        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("bookingList",bookings);
        request.setAttribute("customerList",customers);
        request.setAttribute("employeeList",employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookings/update.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
