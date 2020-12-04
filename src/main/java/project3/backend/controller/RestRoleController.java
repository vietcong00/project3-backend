package project3.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.request.SaveRoleRequest;
import project3.backend.domain.response.*;
import project3.backend.model.EmployeeRole;
import project3.backend.model.RolePageAction;
import project3.backend.service.RoleService;

import java.util.List;


@RestController
@RequestMapping("/role")
public class RestRoleController {


    @Autowired
    private RoleService roleService;


//    @Autowired
//    private EmployeeRoleService employeeRoleService;
//
//    @Autowired
//    private RolePageActionService rolePageActionService;

    //role
    @CrossOrigin(origins = "*")
    @GetMapping("/roleList")
    public ResponseEntity<RoleListResponse> getAllRole(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(roleService.getAllRole(token));
    }
    

    @CrossOrigin(origins = "*")
    @PostMapping("/saveRole")
    public ResponseEntity<RoleResponse> saveRole(@RequestHeader("Authorization") String token, @RequestBody SaveRoleRequest saveRoleRequest) {
        return ResponseEntity.ok(roleService.saveRole(token,saveRoleRequest));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteRole/{idRole}")
    public ResponseEntity<BaseResponse> deleteRole(@RequestHeader("Authorization") String token, @PathVariable int idRole) {
        return ResponseEntity.ok(roleService.deleteRole(token,idRole));
    }

    //    employeeRole
    @CrossOrigin(origins = "*")
    @PostMapping("/saveEmployeeRoleList")
    public ResponseEntity<EmployeeRoleListResponse> saveEmployeeRoleList(@RequestHeader("Authorization") String token, @RequestBody List<EmployeeRole> employeeRoleList) {
        return ResponseEntity.ok(roleService.saveEmployeeRoleList(token,employeeRoleList));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteEmployeeRoleList/{idEmployee}")
    public ResponseEntity<BaseResponse> deleteEmployeeRoleList(@RequestHeader("Authorization") String token,@PathVariable int idEmployee) {
        return ResponseEntity.ok(roleService.deleteEmployeeRoleList(token,idEmployee));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getEmployeeRoleList/{idEmployee}")
    public ResponseEntity<EmployeeRoleListResponse> getEmployeeRoleList(@RequestHeader("Authorization") String token,@PathVariable int idEmployee) {
        return ResponseEntity.ok(roleService.getEmployeeRoleList(token,idEmployee));
    }

    //    rolePageAction
    @CrossOrigin(origins = "*")
    @PostMapping("/saveRolePageAction")
    public ResponseEntity<RolePageListActionResponse> saveRolePageaction(@RequestHeader("Authorization") String token, @RequestBody List<RolePageAction> rolePageActionList) {
        return ResponseEntity.ok(roleService.saveRolePageListAction(token,rolePageActionList));
    }



    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteRolePageAction/{idRole}")
    public ResponseEntity<BaseResponse> deleteRolePageaction(@RequestHeader("Authorization") String token,@PathVariable int idRole) {
        return ResponseEntity.ok(roleService.deleteRolePageListAction(token,idRole));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getRolePageAction/{idRole}")
    public ResponseEntity<RolePageListActionResponse> getRolePageActionByIdRole(@RequestHeader("Authorization") String token, @PathVariable int idRole) {
        return ResponseEntity.ok(roleService.getRolePageAction(token,idRole));
    }


}


