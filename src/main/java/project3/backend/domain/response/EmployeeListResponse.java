package project3.backend.domain.response;

import project3.backend.model.Employee;

import java.util.List;

public class EmployeeListResponse extends BaseResponse{
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
