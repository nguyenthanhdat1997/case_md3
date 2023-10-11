package com.casestudy.case_study.model;

public class UserRole {
    private Long role_id;
    private Long user_id;

    public UserRole() {
    }

    public UserRole(Long role_id, Long user_id) {
        this.role_id = role_id;
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
