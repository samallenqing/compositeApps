package demo.service;

import demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;

import java.util.List;


public interface EmployeeService  {
    List<Employee> findAllEmployee();
    void addEmployee(Employee employee);
    List<Employee> findEmployeeByName(String name);
    void saveAll(List<Employee> employees);
    void deleteAll();
    void removeEmployeById(String id);
}
