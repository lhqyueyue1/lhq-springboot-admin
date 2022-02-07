package com.gxuwu.admin.service;

import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.Role;

import java.util.List;

public interface RoleService {

    public PageInfo<Role> getPageList(Integer page, Integer pageSize, String keyword);

    public void addRole(Role role);

    public void updateRole(Role role);

    public void removeById(String id);


    public void removeBatch(List<String> roleIdList);
}
