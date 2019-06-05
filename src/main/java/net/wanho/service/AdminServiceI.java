package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Admin;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
public interface AdminServiceI {
    Admin LoginCheck(String adminName, String adminPassword);

}
