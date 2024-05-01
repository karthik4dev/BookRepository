package com.karthikProject.Authserver.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter

public enum Roles {
    ROLE_ADMIN(1),ROLE_NORMAL(2),ROLE_OWNER(3);

    private final int roleId;
    Roles(int id){
        this.roleId=id;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
