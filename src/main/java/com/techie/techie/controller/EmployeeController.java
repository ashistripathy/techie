package com.techie.techie.controller;

import com.techie.techie.dto.EmployeeDTO;
import com.techie.techie.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;
    ServletContext context;
    /*Create Employee*/
    @RequestMapping(value = "/createEmployee",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody ResponseEntity<Map<String,String>> createEmployee(HttpServletRequest request, @RequestBody EmployeeDTO newEmployee) throws SQLException{
        //log.info("input json : "+ newEmployee.toString());
        String resultMessage = "null";
        try{
            resultMessage = employeeService.createEmployee(newEmployee);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Map<String,String> result = new HashMap<>();
        result.put("result",resultMessage);
        return new ResponseEntity<Map<String,String>>(result,HttpStatus.OK );
    }
    /*Get Employee*/
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET,produces = "application/json")
    public List<EmployeeDTO> getEmployeeList() throws SQLException{
        log.info("Employee List controller");

        List<EmployeeDTO> result = null;
        try{
            result = employeeService.getEmployeeList();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return result;
    }
    /*Get Employee by id */
    @RequestMapping(value = "/employee/{empno}",method = RequestMethod.GET, produces = "application/json")
    public EmployeeDTO getEmployeeById(@RequestParam int empno ) throws SQLException {
        log.info("Emp ID : " + empno);

        EmployeeDTO result = null;
        try {
            result = employeeService.getEmployeeById(empno);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
