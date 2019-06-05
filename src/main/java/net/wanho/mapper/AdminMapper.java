package net.wanho.mapper;

import net.wanho.pojo.Admin;
import net.wanho.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
public interface AdminMapper {

    Admin LoginCheck(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);



}
