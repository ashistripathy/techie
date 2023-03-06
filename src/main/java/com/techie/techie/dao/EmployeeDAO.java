package com.techie.techie.dao;

import com.techie.techie.controller.EmployeeController;
import com.techie.techie.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:queries.properties")
public class EmployeeDAO {
    private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);
    @Autowired
    private Environment env;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
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

    public List<EmployeeDTO> getEmployeeLists() {
        String getEmployeeList = env.getProperty("query.getEmployeeList");
        List<EmployeeDTO> result = null;
        try{
            MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();

            result = namedParameterJdbcTemplate.query(getEmployeeList,sqlParameterSource,
                    new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
        }catch(Exception exp){
            log.info("Exception while getting employee list : " + exp.toString());
        }
        return result;
    }

    private void updateEmployeeObject(List<EmployeeDTO> result) {

    }
}
