package demo.service.impl;

import demo.model.Employee;
import demo.repository.EmployeeRepository;
import demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAllEmployee() {
       return  employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {

        return employeeRepository.findEmployeeByNameContains(name);
    }

    @Override
    public void saveAll(List<Employee> employees) {
        employeeRepository.save(employees);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();

    }

    @Override
    public void removeEmployeById(String id) {
        employeeRepository.deleteEmployeeById(id);

    }
}
