package com.gxuwu.admin.controller;

import com.github.pagehelper.PageInfo;
import com.gxuwu.admin.entity.MyUser;
import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.service.MyUserService;
import com.gxuwu.admin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/user")
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    /**
     * 根据当前用户分配角色
     * @return
     */
    @PostMapping("/doAssign")
    public R doAssagin(String userId,List<String> roleIdList){


        myUserService.soAssgin(userId,roleIdList);

        return R.ok();
    }

    /**
     * 获取用户角色数据
     * @param userId
     * @return
     */
    @GetMapping("/toAssign/{userId}")
    public R toAssign(@PathVariable("userId") String userId){


        List<Role> noAssginRoleList = myUserService.noAssginByUserId(userId);

        List<Role> assginRoleLis = myUserService.AssginByUserId(userId);

        return R.ok().data("noAssginRoleList",noAssginRoleList).data("assginRoleLis",assginRoleLis);
    }
    @PostMapping("/save")
    public R saveUser(MyUser user){

        System.out.println("添加的用户"+user.toString());

        myUserService.addUser(user);

        return R.ok();
    }
    @PutMapping("/update")
    public R updateById(MyUser user){

        System.out.println("当前修改的用户"+user.toString());
        //设置当前日期为修改时间
        Date date = new Date();
        user.setGmtModified(date);

        myUserService.update(user);

        return R.ok();
    }

    @DeleteMapping("/batchRemove")
    public R batchRemove(@RequestParam("idList") List<String> idList){

        System.out.println("当前要删除的用户id"+idList);

        myUserService.deleteByIdBatch(idList);

        return R.ok();
    }

    @DeleteMapping("/remove/{id}")
    public R removeById(@PathVariable("id") String id){
//        System.out.println(id);
        myUserService.deleteById(id);

        return R.ok();
    }


    @GetMapping("/{page}/{pageSize}")
    public PageInfo<MyUser> getUserList(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize){
        PageInfo<MyUser> userList = myUserService.getUserList(1, 3);
//        System.out.println(page+"=="+pageSize);

        return userList;
    }



}
