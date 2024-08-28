package com.kb.employee_service.service;

import com.kb.employee_service.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    EmployeeDto fetchEmployee(String mobileNumber);

    boolean updateEmployee(EmployeeDto employeeDto);

    boolean deleteEmployee(String mobileNumber);

    List<EmployeeDto> fetchAllEmployees();
}
