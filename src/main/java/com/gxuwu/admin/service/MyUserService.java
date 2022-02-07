package com.gxuwu.admin.service;

import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.MyUser;
import com.gxuwu.admin.entity.Role;

import java.util.List;
import java.util.Map;

public interface MyUserService {

    public PageInfo<MyUser> getUserList(Integer page, Integer pageSize);

    public List<MyUser> getUserByKeyword(String keyword);

    public void addUser(MyUser user);


    public void update(MyUser user);


    public void deleteById(String id);

    public void deleteByIdBatch(List<String> idList);

    List<Role> AssginByUserId(String userId);
    List<Role> noAssginByUserId(String userId);

    void doAssgin(String userId, List<String> roleIdList);
}
