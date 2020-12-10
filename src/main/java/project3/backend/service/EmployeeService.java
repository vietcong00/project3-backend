package project3.backend.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.BaseResponse;
import project3.backend.domain.response.EmployeeListResponse;
import project3.backend.domain.response.EmployeeResponse;
import project3.backend.helper.helper.JwtTokenUtil;
import project3.backend.helper.helper.Regex;
import project3.backend.model.*;
import project3.backend.repository.EmployeeRepository;
import project3.backend.repository.EmployeeRoleRepository;
import project3.backend.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class EmployeeService extends CommonService {

    private final String thisPage = "employee.html";

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmployeeRoleRepository employeeRoleRepository;

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
        if (employee == null) {
            baseResponse.setCode("999");
            baseResponse.setMessage("replace login");
        } else {
            baseResponse.setCode("200");
            baseResponse.setMessage("success !");
        }

        return baseResponse;
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

    public EmployeeResponse saveEmployee(String token, Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee oldEmployee = employeeRepository.findByIdEmployee(employee.getIdEmployee());
        if (employee.getIdEmployee() == -1) {
            if (checkToken(token, thisPage, "add")) {
                if (!employee.getEmailEmployee().matches(Regex.EMAIL_REGEX)) {
                    employeeResponse.setCode("201");
                    employeeResponse.setMessage("Wrong format email !");
                } else if (!employee.getPhoneEmployee().matches(Regex.PHONE_REGREX)) {
                    employeeResponse.setCode("202");
                    employeeResponse.setMessage("Wrong format phone !");
                } else if (employeeRepository.findByEmailEmployee(employee.getEmailEmployee()) != null) {
                    employeeResponse.setCode("203");
                    employeeResponse.setMessage("Email already exists !");
                } else if (employeeRepository.findByPhoneEmployee(employee.getPhoneEmployee()) != null) {
                    employeeResponse.setCode("204");
                    employeeResponse.setMessage("Phone already exists !");
                } else if (employeeRepository.findByEmailEmployee(employee.getUsernameEmployee()) != null) {
                    employeeResponse.setCode("205");
                    employeeResponse.setMessage("User already exists !");
                } else {
                    employeeRepository.save(employee);
                    Employee newEmployee = employeeRepository.findByEmailEmployee(employee.getEmailEmployee());
                    System.out.println(employee.getEmailEmployee());
                    employeeRoleRepository.save(new EmployeeRole(roleRepository.findByNameRole(employee.getPositionEmployee()).getIdRole(), newEmployee.getIdEmployee()));

                    employeeResponse.setCode("200");
                    employeeResponse.setMessage("Insert Employee success");
                    employeeResponse.setEmployee(newEmployee);

                }
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                if (!employee.getPhoneEmployee().matches(Regex.PHONE_REGREX)) {
                    employeeResponse.setCode("202");
                    employeeResponse.setMessage("Wrong format phone !");
                } else {

                    employee.setPasswordEmployee(oldEmployee.getPasswordEmployee());
                    employee.setEmailEmployee(oldEmployee.getEmailEmployee());
                    employee.setUsernameEmployee(oldEmployee.getUsernameEmployee());
                    employeeResponse.setCode("000");
                    employeeResponse.setMessage("Edit Employee success");
                    employeeResponse.setEmployee(employee);
                    employeeRepository.save(employee);
                    employeeRoleRepository.findByIdEmployee(employee.getIdEmployee()).get(0).setIdEmployeeRole(roleRepository.findByNameRole(employee.getPositionEmployee()).getIdRole());
                }
            }
        }
        return employeeResponse;
    }

}
