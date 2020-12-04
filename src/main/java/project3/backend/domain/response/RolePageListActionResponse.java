package project3.backend.domain.response;


import project3.backend.model.RolePageAction;

import java.util.List;

public class RolePageListActionResponse extends BaseResponse {
    private List<RolePageAction> rolePageActionList;

    public List<RolePageAction> getRolePageActionList() {
        return rolePageActionList;
    }

    public void setRolePageActionList(List<RolePageAction> rolePageActionList) {
        this.rolePageActionList = rolePageActionList;
    }
}
