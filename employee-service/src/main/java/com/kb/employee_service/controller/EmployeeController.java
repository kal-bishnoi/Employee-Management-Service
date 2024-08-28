package com.kb.employee_service.controller;


import com.kb.employee_service.dto.EmployeeDto;
import com.kb.employee_service.dto.ResponseDto;
import com.kb.employee_service.entity.Employee;
import com.kb.employee_service.service.IEmployeeService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.apache.coyote.Response;
//import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// documentation on swagger ui
@Tag(
        name = "Employee Controller",
        description = "Employee CRUD Operations",
        externalDocs = @ExternalDocumentation(
                description = "Employee Controller",
                url = "http://www.example.com"
        )
)

@Validated
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private IEmployeeService iEmployeeService;

    // documentation swagger ui
    @Operation(
            description = "Create Employee",
            summary = "Post API to create Employee"
    )

    // documentation swagger ui
    @ApiResponse(
            responseCode = "201",
            description = "Employee created successfully"
    )

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        iEmployeeService.createEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("Create successfully", "201")
        );
    }

    @GetMapping("/fetch")
    public ResponseEntity<EmployeeDto> fetchEmployee(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") @NotNull(message = "Mobile Number cannot be empty")  @NotEmpty(message = "Mobile Number cannot be empty") String mobileNumber) {
        EmployeeDto employeeDto = iEmployeeService.fetchEmployee(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello World";
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        boolean isUpdated = iEmployeeService.updateEmployee(employeeDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto("Updated successfully", "203")
            );

        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto("Not updated", "501"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEmployee(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") @NotNull(message = "Mobile Number cannot be empty") @NotEmpty(message = "Mobile Number cannot be empty") String mobileNumber) {
        boolean isDeleted = iEmployeeService.deleteEmployee(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto("Deleted successfully", "200")

            );
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto("Not deleted", "501")
            );
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<EmployeeDto>> fetchAllEmployees() {
        List<EmployeeDto> employeesDto = iEmployeeService.fetchAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeesDto);
    }

    @GetMapping("/build-info")
    public String buildInfo() {
        return buildVersion;
    }


}
