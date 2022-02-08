package com.gxuwu.admin.service;

import com.gxuwu.admin.entity.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> getAllPermission();


    void doAssign(String roleId, List<String> permissionIdList);
}
