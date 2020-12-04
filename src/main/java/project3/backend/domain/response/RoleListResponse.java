package project3.backend.domain.response;


import project3.backend.model.Role;

import java.util.List;

public class RoleListResponse extends BaseResponse{
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
