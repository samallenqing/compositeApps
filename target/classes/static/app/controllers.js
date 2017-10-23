angular.module("app.controllers", [])
    .controller("myCtrl", function (FindEmployeesService) {
            var mc = this;
            mc.employees = [];
            mc.findEmployeesByName = function (cname) {
               FindEmployeesService.findEmployeesByName(cname).then(function (data) {
                   mc.employees = data;
               })
            }
            mc.finAllEmployees = function () {
                FindEmployeesService.finAllEmployees().then(function (data) {
                    mc.employees = data;
                })
            }
            mc.deleteById = function (id) {
                FindEmployeesService.deleteById(id).then(function (data) {
                    mc.employees = data;
                })
            }

            mc.addNew = function (unit) {
                FindEmployeesService.addNew(unit);
            }

    }
    )
