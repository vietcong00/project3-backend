package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.BaseResponse;
import project3.backend.domain.response.EmployeeListResponse;
import project3.backend.domain.response.EmployeeResponse;
import project3.backend.helper.helper.JwtTokenUtil;
import project3.backend.model.*;
import project3.backend.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService extends CommonService {

    private final String thisPage = "employee.html";

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeResponse checkLogin(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String email = employee.getEmailEmployee();
        String password = employee.getPasswordEmployee();

        if (employeeRepository.findByEmailEmployee(email) == null) {
            employeeResponse.setCode("001");
            employeeResponse.setMessage("Sai tài khoản !");
        } else if (!employeeRepository.findByEmailEmployee(email).getPasswordEmployee().equals(password)) {
            employeeResponse.setCode("002");
            employeeResponse.setMessage("Sai mật khẩu !");
        } else if (employeeRepository.findByEmailEmployee(email).getStatusEmployee().equals("Không hoạt động")) {
            employeeResponse.setCode("003");
            employeeResponse.setMessage("Tài khoản đã bị khóa !");
        } else {
            Employee employeeToken = employeeRepository.findByEmailEmployee(email);
            employeeToken.setTokenEmployee(jwtTokenUtil.generateToken(employee));
            employeeRepository.save(employeeToken);
            employeeResponse = findEmployeeInfo(employeeToken.getIdEmployee());
            employeeResponse.setCode("000");
            employeeResponse.setMessage("Success !");
            employeeResponse.setToken(jwtTokenUtil.generateToken(employee));
        }
        return employeeResponse;
    }

    public EmployeeResponse logOut(String token) {
        token = token.replace("Bearer ", "");
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeRepository.findByTokenEmployee(token);
//        System.out.println(token);

        if (employee == null) {
            employeeResponse.setCode("004");
            employeeResponse.setMessage("Your account was remove or not active !");
        } else {
            employee.setTokenEmployee("");
            employeeRepository.save(employee);
            employeeResponse.setCode("000");
            employeeResponse.setMessage("Success !");
        }
        return employeeResponse;
    }

    public EmployeeResponse findEmployeeInfo(int employeeId) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeRepository.findByIdEmployee(employeeId);
        employeeResponse.setEmployee(employee);

        List<EmployeeRole> roleList = employeeRoleRepository.findByIdEmployee(employeeId);
        List<RolePageAction> rolePageActionList = new ArrayList<>();
        List<PageAction> pageActionList = new ArrayList<>();

        for (EmployeeRole employeeRole : roleList) {
            int roleId = employeeRole.getIdRole();
            rolePageActionList.addAll(rolePageActionRepository.findByIdRole(roleId));
        }

        for (RolePageAction rolePageAction : rolePageActionList) {
            int pageId = rolePageAction.getIdPage();
            Page page = pageRepository.findByIdPage(pageId);
            int actionId = rolePageAction.getIdAction();
            Action action = actionRepository.findByIdAction(actionId);

            boolean found = false;
            for (PageAction pageAction : pageActionList) {
                if (pageAction.getPage().getIdPage() == page.getIdPage()) {
                    pageAction.getActionList().add(action);
                    found = true;
                    break;
                }
            }
            if (!found) {
                PageAction pageAction = new PageAction();
                pageAction.setPage(page);
                List<Action> actionList = new ArrayList<>();
                actionList.add(action);
                pageAction.setActionList(actionList);
                pageActionList.add(pageAction);
            }
        }
        employeeResponse.setPageActionList(pageActionList);

        return employeeResponse;
    }

    public BaseResponse checkTokenWeb(String token) {
        BaseResponse baseResponse = new BaseResponse();
        token = token.replace("Bearer ", "");
        Employee employee = employeeRepository.findByTokenEmployee(token);
        //  System.out.println(token);
        if(employee == null){
            baseResponse.setCode("999");
            baseResponse.setMessage("replace login");
        }else {
            baseResponse.setCode("200");
            baseResponse.setMessage("success !");
        }

        return  baseResponse;
    }

    public EmployeeListResponse getAllEmployee(String token) {
        EmployeeListResponse employeeListResponse = new EmployeeListResponse();
        if (checkToken(token, thisPage, "read")) {
            List<Employee> employeeList = employeeRepository.findAll();
            if (employeeList != null) {
                employeeListResponse.setCode("200");
                employeeListResponse.setMessage("success");
                employeeListResponse.setEmployeeList(employeeList);
            } else {
                employeeListResponse.setCode("201");
                employeeListResponse.setMessage("List null !");
            }
        }
        return employeeListResponse;
    }
}
