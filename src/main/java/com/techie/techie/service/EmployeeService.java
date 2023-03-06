package com.techie.techie.service;

import com.techie.techie.dto.EmployeeDTO;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    String createEmployee(EmployeeDTO newEmp) throws ParseException;

    List<EmployeeDTO> getEmployeeList() throws ParseException;
}
