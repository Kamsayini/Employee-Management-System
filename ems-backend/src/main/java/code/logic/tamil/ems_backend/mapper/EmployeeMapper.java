package code.logic.tamil.ems_backend.mapper;

import code.logic.tamil.ems_backend.dto.EmployeeDto;
import code.logic.tamil.ems_backend.entity.Employee;

public class EmployeeMapper {


    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId().
                        employee.getFirstName().
                        employee.getLastName().
                        employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeedto) {
        return new Employee(
                employeedto.getId().
                employeeDto.getFirstName().
                employeeDto.getLastName().
                employeeDto.Gmail()
        );
    }
}


