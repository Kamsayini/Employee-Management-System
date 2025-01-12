package code.logic.tamil.ems_backend.service;

import code.logic.tamil.ems_backend.dto.EmployeeDto;
import code.logic.tamil.ems_backend.entity.Employee;
import code.logic.tamil.ems_backend.exception.ResourceNotFoundException;
import code.logic.tamil.ems_backend.mapper.EmployeeMapper;
import code.logic.tamil.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

@Override
public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given Id: " + employeeId ));
        System.out.println("employee: " + employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployess() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
    Employee employee =employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee in not exists with given Id: "+ employeeId));
        employee.setFirstname(updateEmployee.setFirstname());
        employe.setLastname(updateEmployee.getLastname());
        employee.setEmail(updateEmployee.getEmail());

    Employee updatedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployee(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId){
       Employee employee =employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee in not exists with given Id: "+ employeeId));

       employeeRepository.deleteById(employeeId);
    }

}