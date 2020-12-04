package project3.backend.domain.request;



import project3.backend.model.Role;
import project3.backend.model.RolePageAction;

import java.util.List;

public class SaveRoleRequest {
    Role role;

    List<RolePageAction> rolePageActionList;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<RolePageAction> getRolePageActionList() {
        return rolePageActionList;
    }

    public void setRolePageActionList(List<RolePageAction> rolePageActionList) {
        this.rolePageActionList = rolePageActionList;
    }
}
