package demo.repository;

import demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String>, MongoRepository<Employee, String> {
    @RestResource(rel = "by-name", description = @Description("Find employee by name."))
    public List<Employee> findEmployeeByNameContains(@Param("name") String name);

    @RestResource(rel = "delect-by-id", description = @Description("Delete employee by Id"))
    public void deleteEmployeeById(@Param("id") String id);
}
