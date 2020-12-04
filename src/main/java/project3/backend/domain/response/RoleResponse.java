package project3.backend.domain.response;


import project3.backend.model.Role;

public class RoleResponse extends BaseResponse {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
