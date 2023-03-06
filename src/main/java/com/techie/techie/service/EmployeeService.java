package com.techie.techie.service;

import com.techie.techie.dto.EmployeeDTO;

import java.text.ParseException;

public interface EmployeeService {
    String createEmployee(EmployeeDTO newEmp) throws ParseException;
}
