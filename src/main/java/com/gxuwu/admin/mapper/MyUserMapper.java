package com.gxuwu.admin.mapper;

import com.gxuwu.admin.entity.MyUser;
import com.gxuwu.admin.entity.MyUserExample;
import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface MyUserMapper {
    int countByExample(MyUserExample example);

    int deleteByExample(MyUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    List<MyUser> selectByExample(MyUserExample example);

    MyUser selectByPrimaryKey(String id);

    List<MyUser> selectByLimit(@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    int updateByExampleSelective(@Param("record") MyUser record, @Param("example") MyUserExample example);

    int updateByExample(@Param("record") MyUser record, @Param("example") MyUserExample example);

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);

    void deleteBatchRemove(@Param("idList") List<String> idList);


    List<Role> AssginByUserId(String userId);

    List<Role> noAssginByUserId(String userId);

    void insertUserAndRoleRelation(
            @Param("userId") String userId,
            @Param("roleIdList") List<String> roleIdList,
            @Param("userRole")UserRole userRole);
}
