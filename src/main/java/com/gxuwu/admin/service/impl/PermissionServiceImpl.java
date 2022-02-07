package com.gxuwu.admin.service.impl;

import com.gxuwu.admin.mapper.PermissionMapper;
import com.gxuwu.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
}
