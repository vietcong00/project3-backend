package project3.backend.domain.response;

import project3.backend.model.Employee;
import project3.backend.model.PageAction;

import java.util.List;

public class EmployeeResponse extends BaseResponse {
    Employee employee;

    List<PageAction> pageActionList;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<PageAction> getPageActionList() {
        return pageActionList;
    }

    public void setPageActionList(List<PageAction> pageActionList) {
        this.pageActionList = pageActionList;
    }
}
