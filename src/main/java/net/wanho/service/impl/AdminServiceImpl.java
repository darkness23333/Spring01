package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.AdminMapper;
import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Admin;
import net.wanho.pojo.Student;
import net.wanho.service.AdminServiceI;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
@Service
public class AdminServiceImpl implements AdminServiceI {

    @Autowired
    private AdminMapper mapper;

    @Override
    public Admin LoginCheck(String adminName, String adminPassword) {
       Admin admin= mapper.LoginCheck(adminName,adminPassword);

            return admin;

    }
}
