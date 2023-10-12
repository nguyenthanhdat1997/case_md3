package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IBookingDAO;
import com.casestudy.case_study.DAO.impl.BookingDAO;
import com.casestudy.case_study.model.Booking;
import com.casestudy.case_study.service.IBookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
    public boolean add(Booking booking) {
        return bookingDAO.add(booking);
    }

    @Override
    public boolean update(Booking booking) {
        return bookingDAO.update(booking);
    }

    @Override
    public boolean remove(Long id) {
        return bookingDAO.remove(id);
    }

}
