package com.techie.techie.dao;

import com.techie.techie.controller.EmployeeController;
import com.techie.techie.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:queries.properties")
public class EmployeeDAO {
    private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);
    @Autowired
    private Environment env;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public String createEmployee(EmployeeDTO newEmp) {
        //log.info("Inside DAO");
        String createEmployeeQuery = env.getProperty("query.createEmployee");
        String output = null;
        try{
            int rows = jdbcTemplate.update(createEmployeeQuery,newEmp.getEmpno(),newEmp.getEname(),newEmp.getJob(),newEmp.getMgr(),newEmp.getHiredate(),newEmp.getSal(),newEmp.getComm(),newEmp.getDeptno());
            log.info("Rows Count "+rows);
            if(rows>=1){
                output = "Record Inserted Successfully.";
            }
            log.info("Employee creation :" + output);
        }catch(Exception exp){
           exp.printStackTrace();
        }

        return output;
    }
}
