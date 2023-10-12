package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.ICustomerDAO;
import com.casestudy.case_study.DAO.impl.CustomerDAO;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAO = new CustomerDAO();

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public boolean add(Customer object) {
        return customerDAO.add(object);
    }

    @Override
    public boolean update(Customer object) {
        return customerDAO.update(object);
    }

    @Override
    public boolean remove(Long id) {
        return customerDAO.remove(id);
    }
}
