package com.gxuwu.admin.controller;

import com.gxuwu.admin.entity.Permission;
import com.gxuwu.admin.service.PermissionService;
import com.gxuwu.admin.utils.R;
import org.apache.ibatis.type.SimpleTypeRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 给角色分配权限
     * @return
     */
    @PostMapping("/doAssign")
    public R doAssign(String roleId,List<String> permissionIdList){

        permissionService.doAssign(roleId,permissionIdList);

        return R.ok();
    }

    @GetMapping("/list")
    public R getPermission(){

        List<Permission> allPermission = permissionService.getAllPermission();


        return R.ok().data("chidren",allPermission);


    }


}
