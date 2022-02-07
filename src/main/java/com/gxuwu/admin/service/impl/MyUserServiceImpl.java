package com.gxuwu.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.MyUser;
import com.gxuwu.admin.entity.MyUserExample;
import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.mapper.MyUserMapper;
import com.gxuwu.admin.service.MyUserService;
import com.gxuwu.admin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private MyUserMapper myUserMapper;


    @Override
    public PageInfo<MyUser> getUserList(Integer page,Integer pageSize) {

        Page<Object> pageHelp = PageHelper.startPage(page,pageSize);

        List<MyUser> myUsers = myUserMapper.selectByLimit(page - 1, pageSize);

        PageInfo<MyUser> pageInfo = new PageInfo<>(myUsers);


        return pageInfo;
    }

    @Override
    public List<MyUser> getUserByKeyword(String keyword) {
        return null;
    }

    @Override
    public void addUser(MyUser user) {
        myUserMapper.insert(user);

    }

    @Override
    public void update(MyUser user) {
        myUserMapper.updateByPrimaryKey(user);

    }

    @Override
    public void deleteById(String id) {
        myUserMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void deleteByIdBatch(List<String> idList) {

        myUserMapper.deleteBatchRemove(idList);
    }

    @Override
    public List<Role> AssginByUserId (String userId) {

        List<Role> assginRoleList = myUserMapper.AssginByUserId(userId);

        return assginRoleList;

    }

    @Override
    public List<Role> noAssginByUserId(String userId) {

        List<Role> noAssginRoleList = myUserMapper.noAssginByUserId(userId);
        return noAssginRoleList;
    }

    @Override
    public void soAssgin(String userId, List<String> roleIdList) {
        myUserMapper.insertUserAndRoleRelation(userId,roleIdList);
    }
}
