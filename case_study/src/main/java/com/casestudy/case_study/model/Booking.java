package com.casestudy.case_study.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private String book_time;
    private String status;
    private Long customer_id;
    private Long employee_id;

    public Booking(Long id, String book_time, String status, Long customer_id, Long employee_id) {
        this.id = id;
        this.book_time = book_time;
        this.status = status;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
    }

    public Booking(String book_time, String status, Long customer_id, Long employee_id) {
        this.book_time = book_time;
        this.status = status;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }
}
