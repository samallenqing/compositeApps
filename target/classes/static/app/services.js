angular.module('app.services',[])
.service("FindEmployeesService", function ($http) {
    this.findEmployeesByName = function findEmployeeByName(name) {
        var query = 'api/employee?name='+name;

        return $http.get(query).then(function success(response) {
            return response.data;
        },
            function fail(response) {
                return response;
            })
    }

    this.finAllEmployees = function findAll() {
        var query = 'api/employees';
        return $http.get(query).then(function success(response) {
            return response.data;
        })
    }

    this.deleteById = function removeEmployeById(id) {
        var url = "api/employees/" + id;
        return $http.delete(url).then(function (response) {
            return response.data;
        })

    }

    this.addNew = function addNew(employee) {
        var url = "api/employee";
         $http.post(url, employee).then(function (response) {
             return response.data;
         })
    }
});
