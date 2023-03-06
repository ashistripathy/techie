package com.techie.techie.service.impl;

import com.techie.techie.controller.EmployeeController;
import com.techie.techie.dao.EmployeeDAO;
import com.techie.techie.dto.EmployeeDTO;
import com.techie.techie.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public String createEmployee(EmployeeDTO newEmp) throws ParseException {
        //log.info("inside impl");
        return employeeDAO.createEmployee(newEmp);
    }
}
