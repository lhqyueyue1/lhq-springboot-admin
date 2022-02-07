package com.gxuwu.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.MyUser;
import com.gxuwu.admin.entity.MyUserExample;
import com.gxuwu.admin.mapper.MyUserMapper;
import com.gxuwu.admin.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void toAssginByUserId(String userId) {
//        myUserMapper.toAssginByUserId(userId);
    }
}
