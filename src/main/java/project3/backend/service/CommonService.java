package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.model.Employee;
import project3.backend.model.EmployeeRole;
import project3.backend.repository.*;


import java.util.List;


@Service
public class CommonService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;


//    ConfigPasswordRequest configPassword =new ConfigPasswordRequest();

    public boolean checkToken(String token, String url, String action) {
        token = token.replace("Bearer ", "");
        if (token=="" || token == null) return false;
        Employee employee = employeeRepository.findByTokenEmployee(token);
        if (employee == null ) return false;

        boolean found = false;
        int idPage = pageRepository.findByUrlPage(url).getIdPage();
        int idAction = actionRepository.findByNameAction(action).getIdAction();
        int employeeId = employee.getIdEmployee();
        List<EmployeeRole> roleList = employeeRoleRepository.findByIdEmployee(employeeId);
        for (EmployeeRole employeeRole : roleList) {
            if (rolePageActionRepository.findByIdRoleAndIdPageAndIdAction(employeeRole.getIdRole(), idPage, idAction) != null) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean checkBaseToken(String token) {
        token = token.replace("Bearer ", "");
        if (token=="" || token == null) return false;
        Employee employee = employeeRepository.findByTokenEmployee(token);
        if (employee == null ) return false;

        return true;
    }

}

