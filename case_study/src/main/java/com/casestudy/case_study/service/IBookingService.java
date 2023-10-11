package com.casestudy.case_study.service;

import com.casestudy.case_study.model.Booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IBookingService extends IUtilService<Booking> {
    boolean addBooking(HttpServletRequest request,HttpServletResponse response) throws IOException;
    boolean updateBooking(HttpServletRequest request,HttpServletResponse response) throws IOException;
}
