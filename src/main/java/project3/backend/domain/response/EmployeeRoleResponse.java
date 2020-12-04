package project3.backend.domain.response;


import project3.backend.model.EmployeeRole;

public class EmployeeRoleResponse extends BaseResponse {
    private EmployeeRole employeeRole;

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
