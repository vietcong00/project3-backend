package project3.backend.domain.response;

import project3.backend.model.EmployeeRole;

import java.util.List;

public class EmployeeRoleListResponse extends BaseResponse {
    List<EmployeeRole> employeeRoleList;

    public List<EmployeeRole> getEmployeeRoleList() {
        return employeeRoleList;
    }

    public void setEmployeeRoleList(List<EmployeeRole> employeeRoleList) {
        this.employeeRoleList = employeeRoleList;
    }
}
