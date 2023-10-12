package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.ICustomerTypeDAO;
import com.casestudy.case_study.DAO.impl.CustomerTypeDAO;
import com.casestudy.case_study.model.CustomerType;
import com.casestudy.case_study.service.ICustomerService;
import com.casestudy.case_study.service.ICustomerTypeService;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private final ICustomerTypeDAO customerTypeDAO = new CustomerTypeDAO();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeDAO.findAll() ;
    }

    @Override
    public CustomerType findById(Long id) {
        return null;
    }

    @Override
    public boolean add(CustomerType object) {
        return false;
    }

    @Override
    public boolean update(CustomerType object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
