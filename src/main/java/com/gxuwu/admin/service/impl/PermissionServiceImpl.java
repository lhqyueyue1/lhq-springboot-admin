package com.gxuwu.admin.service.impl;

import com.gxuwu.admin.entity.Permission;
import com.gxuwu.admin.mapper.PermissionMapper;
import com.gxuwu.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAllPermission() {

        List<Permission> permissionList = permissionMapper.selectByExample(null);


        List<Permission> result = bulid(permissionList);

        return result;
    }

    @Override
    public void doAssign(String roleId, List<String> permissionIdList) {

    }

    /**
     * 使用递归方法建菜单
     * @param treeNodes
     * @return
     */
    private static List<Permission> bulid(List<Permission> treeNodes) {


        List<Permission> trees = new ArrayList<>();

        for (Permission treeNode : treeNodes) {
            //查找父节id为0的节点为根节点
            if ("0".equals(treeNode.getPid())) {
//                递归查找对应的子节点
                trees.add(findChildren(treeNode,treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    private static Permission findChildren(Permission treeNode,List<Permission> treeNodes) {
        treeNode.setChidren(new ArrayList<Permission>());

        for (Permission it : treeNodes) {
            if(treeNode.getId().equals(it.getPid())) {
//
                if (treeNode.getChidren() == null) {
                    treeNode.setChidren(new ArrayList<>());
                }
                //设置子节点
                treeNode.getChidren().add(findChildren(it,treeNodes));
            }
        }
        return treeNode;
    }


}
