package com.gxuwu.admin.entity;

import java.util.Date;

public class UserRole {
    private String id;

    private String roleId;

    private String userId;

    private Date gmtCreate;

    private Date gmtModified;

    public UserRole() {
    }

    public UserRole(String id, String roleId, String userId, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
