package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
public interface StudentServiceI {
    PageInfo<Student> queryAll(Integer pageNum);

    void AddStu(Student student);

    void updateStuById(Student student);

    void delStuById(Integer id);

    Student queryStuById(Integer id);

    void OpenStu(Integer id);

    void CloseStu(Integer id);

    PageInfo<Student> QLike(Integer pageNum,String name);

}
