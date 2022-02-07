package com.gxuwu.admin.service;

import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.MyUser;

import java.util.List;

public interface MyUserService {

    public PageInfo<MyUser> getUserList(Integer page, Integer pageSize);

    public List<MyUser> getUserByKeyword(String keyword);

    public void addUser(MyUser user);


    public void update(MyUser user);


    public void deleteById(String id);

    public void deleteByIdBatch(List<String> idList);

    void toAssginByUserId(String userId);
}
