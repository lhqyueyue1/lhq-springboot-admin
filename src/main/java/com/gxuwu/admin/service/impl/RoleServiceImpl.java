package com.gxuwu.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.mapper.RoleMapper;
import com.gxuwu.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageList(Integer page, Integer pageSize,String keyword) {
        Page<Role> startPage = PageHelper.startPage(page, pageSize);

        List<Role> list=roleMapper.selectByLimit(page-1,pageSize,keyword);

        PageInfo<Role> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void addRole(Role role) {

        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);

    }

    @Override
    public void removeById(String id) {

        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeBatch(List<String> roleIdList) {

        roleMapper.deleteBatchById(roleIdList);
    }
}
