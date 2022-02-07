package com.gxuwu.admin.mapper;

import com.gxuwu.admin.entity.Role;
import com.gxuwu.admin.entity.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByLimit(@Param("begin") Integer begin,
                             @Param("pageSize") Integer pageSize,
                             @Param("keyword") String keyword);

    void deleteBatchById(@Param("roleIdList") List<String> roleIdList);
}
