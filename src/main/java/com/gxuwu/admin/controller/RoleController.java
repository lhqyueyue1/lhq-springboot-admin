package com.gxuwu.admin.controller;

import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.service.RoleService;
import com.gxuwu.admin.utils.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/acl/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/get/{id}")
    public R getRole(@PathVariable("id") String id){
        return R.ok();
    }

    @GetMapping("/{page}/{pageSize}")
    public R getPageList(
            @PathVariable("page") Integer page,
            @PathVariable("pageSize") Integer pageSize,
            String keyword
            ){
        PageInfo<Role> pageList = roleService.getPageList(page, pageSize, keyword);

        return R.ok().data("list",pageList);

    }

    @PostMapping("/save")
    public R saveRole(Role role){

        roleService.addRole(role);

        return R.ok();
    }
    @PutMapping("/update")
    public R updateRole(Role role){

        roleService.updateRole(role);

        return R.ok();
    }

    @DeleteMapping("/batchRemove")
    public R removeBatchRole(List<String> roleIdList){
        roleService.removeBatch(roleIdList);

        return R.ok();
    }
    @DeleteMapping("/remove/{id}")
    public R removeRole(@PathVariable("id") String id){

        roleService.removeById(id);
        return R.ok();
    }

}
