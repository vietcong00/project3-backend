package project3.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project3.backend.domain.request.SaveRoleRequest;
import project3.backend.domain.response.*;
import project3.backend.model.EmployeeRole;
import project3.backend.model.Role;
import project3.backend.model.RolePageAction;
import project3.backend.repository.EmployeeRoleRepository;
import project3.backend.repository.RolePageActionRepository;
import project3.backend.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService extends CommonService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;

    private String thisPage = "roles.html";

    //    role
    public RoleListResponse getAllRole(String token) {
        RoleListResponse roleListResponse = new RoleListResponse();
        if (checkToken(token, thisPage, "read") || checkToken(token, "employees.html", "edit")) {
            List<Role> roleList = roleRepository.findAll(Sort.by(Sort.Direction.ASC, "idRole"));
            if (roleList != null) {
                roleListResponse.setCode("200");
                roleListResponse.setMessage("get All success !");
                roleListResponse.setRoleList(roleList);

            } else {
                roleListResponse.setCode("201");
                roleListResponse.setMessage("get All error!");
            }
        }
        return roleListResponse;
    }

    public RoleResponse saveRole(String token, SaveRoleRequest saveRoleRequest) {
        RoleResponse roleResponse = new RoleResponse();
        Role role = saveRoleRequest.getRole();
        int idRole = role.getIdRole();
        String nameRole = role.getNameRole();
        if (idRole == -1) {
            if (checkToken(token, thisPage, "add")) {
                if (roleRepository.findByNameRole(nameRole) != null) {
                    roleResponse.setCode("201");
                    roleResponse.setMessage("Tên quyền đã tồn tại !");
                } else {
                    roleRepository.save(new Role(nameRole));
                    role = roleRepository.findByNameRole(nameRole);
                    for (RolePageAction rolePageAction : saveRoleRequest.getRolePageActionList()) {
                        rolePageActionRepository.save(new RolePageAction(role.getIdRole(), rolePageAction.getIdPage(), rolePageAction.getIdAction()));
                    }
                    roleResponse.setCode("000");
                    roleResponse.setMessage("Thêm quyền thành công !");
                    roleResponse.setRole(role);
                }
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                role = roleRepository.findByIdRole(idRole);
                role.setNameRole(nameRole);
                roleRepository.save(role);
                rolePageActionRepository.deleteAll(rolePageActionRepository.findByIdRole(idRole));
                rolePageActionRepository.saveAll(saveRoleRequest.getRolePageActionList());
                roleResponse.setCode("000");
                roleResponse.setMessage("Sửa quyền thành công !");
                roleResponse.setRole(role);
            }

        }

        return roleResponse;
    }

    public BaseResponse deleteRole(String token, int idRole) {
        BaseResponse baseResponse = new BaseResponse();

        if (checkToken(token, thisPage, "delete")) {
            if (!rolePageActionRepository.findByIdRole(idRole).isEmpty()) {
                rolePageActionRepository.deleteAll(rolePageActionRepository.findByIdRole(idRole));
            }
            if(!employeeRoleRepository.findByIdRole(idRole).isEmpty()){
                employeeRoleRepository.deleteAll(employeeRoleRepository.findByIdRole(idRole));
            }
            roleRepository.delete(roleRepository.findByIdRole(idRole));
            baseResponse.setCode("000");
            baseResponse.setMessage("Xóa quyền thành công!");
        }
        return baseResponse;
    }

//    employeeRole

    public EmployeeRoleListResponse saveEmployeeRoleList(String token, List<EmployeeRole> employeeRoleList) {
        EmployeeRoleListResponse employeeRoleListResponse = new EmployeeRoleListResponse();
        List<EmployeeRole> employeeRoleList1 = new ArrayList<>();
        for (EmployeeRole employeeRole : employeeRoleList) {
            employeeRoleList1 = employeeRoleRepository.findByIdEmployee(employeeRole.getIdEmployee());
        }
        if (employeeRoleList1.isEmpty()) {
            if (checkToken(token, thisPage, "add") || checkToken(token, "employees.html", "add")) {
                employeeRoleListResponse.setCode("200");
                employeeRoleListResponse.setMessage("Thêm EmployeeRoleList thành công !");
                employeeRoleListResponse.setEmployeeRoleList(employeeRoleList);
                employeeRoleRepository.saveAll(employeeRoleList);
            }
        } else {
            if (checkToken(token, thisPage, "edit") || checkToken(token, "employees.html", "edit")) {
                employeeRoleRepository.deleteAll(employeeRoleList1);
                employeeRoleRepository.saveAll(employeeRoleList);
                employeeRoleListResponse.setCode("201");
                employeeRoleListResponse.setMessage("Sửa EmployeeRoleList thành công !");
                employeeRoleListResponse.setEmployeeRoleList(employeeRoleList);
            }
        }
        return employeeRoleListResponse;
    }

    //   xóa cùng lúc xóa nhân viên luôn lên không cần dùng !
    public BaseResponse deleteEmployeeRoleList(String token, int idEmployee) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            List<EmployeeRole> employeeRoleList = employeeRoleRepository.findByIdEmployee(idEmployee);
            if (employeeRoleList.isEmpty()) {
                baseResponse.setCode("301");
                baseResponse.setMessage("Người dùng không tồn tại !");
            } else {
                baseResponse.setCode("300");
                baseResponse.setMessage("Xóa EmployeeRole thành công");
                employeeRoleRepository.deleteAll(employeeRoleList);
            }
        }
        return baseResponse;
    }

    public EmployeeRoleListResponse getEmployeeRoleList(String token, int idEmployee) {
        EmployeeRoleListResponse employeeRoleListResponse = new EmployeeRoleListResponse();
        if (checkToken(token, thisPage, "read") || checkToken(token, "employees.html", "edit")) {
            if (employeeRepository.findByIdEmployee(idEmployee) != null) {
                List<EmployeeRole> employeeRoleList = employeeRoleRepository.findByIdEmployee(idEmployee);

                if (employeeRoleList.isEmpty()) {
                    employeeRoleListResponse.setCode("101");
                    employeeRoleListResponse.setMessage("null");
                } else {
                    employeeRoleListResponse.setCode("100");
                    employeeRoleListResponse.setMessage("success");
                    employeeRoleListResponse.setEmployeeRoleList(employeeRoleList);
                }
            } else {
                employeeRoleListResponse.setCode("102");
                employeeRoleListResponse.setMessage("Employee not exist !");
            }
        }
        return employeeRoleListResponse;
    }

    //    rolePageAction
//    public List<RolePageAction> getAllRPA(String token) {
//        return rolePageActionRepository.findAll();
//    }

    public RolePageListActionResponse saveRolePageListAction(String token, List<RolePageAction> rolePageActionList) {
    //    System.out.println(rolePageActionList);
        RolePageListActionResponse rolePageListActionResponse = new RolePageListActionResponse();
        List<RolePageAction> rolePageActionList1 = new ArrayList<>();
        for (RolePageAction rolePageAction : rolePageActionList) {
            rolePageActionList1 = rolePageActionRepository.findByIdRole(rolePageAction.getIdRole());
        }
        if (rolePageActionList1.isEmpty()) {
            if (checkToken(token, thisPage, "add")) {
                rolePageListActionResponse.setCode("200");
                rolePageListActionResponse.setMessage("Thêm RPA thành công !");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
                rolePageActionRepository.saveAll(rolePageActionList);
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                rolePageActionRepository.deleteAll(rolePageActionList1);
                rolePageActionRepository.saveAll(rolePageActionList);
                rolePageListActionResponse.setCode("201");
                rolePageListActionResponse.setMessage("Sửa RPA thành công !");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
            }
        }
        return rolePageListActionResponse;
    }


    public BaseResponse deleteRolePageListAction(String token, int idRole) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "deldete")) {
            List<RolePageAction> rolePageActionList = rolePageActionRepository.findByIdRole(idRole);
            if (rolePageActionList.isEmpty()) {
                baseResponse.setCode("301");
                baseResponse.setMessage("Quyền không tồn tại !");
            } else {
                baseResponse.setCode("300");
                baseResponse.setMessage("Xóa RPA thành công");
                rolePageActionRepository.deleteAll(rolePageActionList);
            }
        }
        return baseResponse;
    }

    public RolePageListActionResponse getRolePageAction(String token, int idRole) {
       // System.out.println(idRole);
        RolePageListActionResponse rolePageListActionResponse = new RolePageListActionResponse();
        if (checkToken(token, thisPage, "read")) {

            List<RolePageAction> rolePageActionList = rolePageActionRepository.findByIdRole(idRole);

            if (roleRepository.findByIdRole(idRole) == null) {
                rolePageListActionResponse.setCode("102");
                rolePageListActionResponse.setMessage("Role not exist !");
            }
            else if (rolePageActionList.isEmpty()) {
                rolePageListActionResponse.setCode("101");
                rolePageListActionResponse.setMessage("PageAction null");
            }else {
                rolePageListActionResponse.setCode("100");
                rolePageListActionResponse.setMessage("success");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
            }
        }
        return rolePageListActionResponse;
    }
}
