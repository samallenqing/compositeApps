package demo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Employee;
import demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uplodeEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveAll(employees);
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public List<Employee> showAll() {
        return employeeService.findAllEmployee();
    }


    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public List<Employee> findEmployeesByName(@RequestParam(value = "name") String name) {
        return employeeService.findEmployeeByName(name);
    }

    @RequestMapping(value = "employees", method = RequestMethod.DELETE)
    public void deletAll() {
        employeeService.deleteAll();
    }

    @RequestMapping(value = "employee", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        log.info("The employee info is:" + employee.getName()+"\n"+employee.getPhoneNumber()+"\n"+employee.getSupervisors());
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.DELETE)
    public List<Employee> deleteById(@PathVariable(value = "id") String id) {
        log.info("The id info is:" + id);
        employeeService.removeEmployeById(id);
        return employeeService.findAllEmployee();
    }


}
