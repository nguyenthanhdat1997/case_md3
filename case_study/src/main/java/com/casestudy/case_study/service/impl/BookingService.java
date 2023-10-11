package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IBookingDAO;
import com.casestudy.case_study.DAO.impl.BookingDAO;
import com.casestudy.case_study.model.Booking;
import com.casestudy.case_study.service.IBookingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class BookingService implements IBookingService {
    private final IBookingDAO bookingDAO = new BookingDAO();
    @Override
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingDAO.findById(id);
    }

    @Override
    public boolean save(Booking object) {
        return bookingDAO.save(object);
    }

    @Override
    public boolean update(Booking object) {
        return bookingDAO.update(object);
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean addBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IBookingService bookingService = new BookingService();
        String book_time = request.getParameter("book_time");

        String status = request.getParameter("status");
        Long customer_id = Long.valueOf(request.getParameter("customer_id"));
        Long employee_id = Long.valueOf(request.getParameter("employee_id"));
        Booking booking = new Booking(book_time,status,customer_id,employee_id);
        boolean success = bookingService.save(booking);
        if (success){
                response.sendRedirect(request.getContextPath() + "/bookings?action=list");
            }
        return false;
    }

    @Override
    public boolean updateBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String book_time = request.getParameter("book_time");
        String status = request.getParameter("status");
        Long customer_id = Long.valueOf(request.getParameter("customer_id"));
        Long employee_id = Long.valueOf(request.getParameter("employee_id"));

        return false;
    }
}
