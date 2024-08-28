package com.kb.employee_service.mapper;

import com.kb.employee_service.dto.EmployeeDto;
import com.kb.employee_service.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {

        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setMobileNumber(employeeDto.getMobileNumber());

        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {

        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setDesignation(employee.getDesignation());
        employeeDto.setMobileNumber(employee.getMobileNumber());

        return employeeDto;
    }

}
