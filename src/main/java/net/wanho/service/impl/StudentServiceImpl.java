package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
@Service
public class StudentServiceImpl implements StudentServiceI {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> queryAll(Integer pageNum) {
        //设置分页信息
        PageHelper.startPage(pageNum,5);
        List<Student> StuList=studentMapper.queryAll();
        PageInfo<Student> pageInfo=new PageInfo<Student>(StuList);
        return pageInfo;

    }

    @Override
    public void AddStu(Student student) {
        studentMapper.AddStu(student);
    }

    @Override
    public void updateStuById(Student student) {
        studentMapper.updateStuById(student);
    }

    @Override
    public void delStuById(Integer id) {
        studentMapper.delStuById(id);
    }

    @Override
    public Student queryStuById(Integer id) {
        return studentMapper.queryStuById(id);
    }

    @Override
    public void OpenStu(Integer id) {
        studentMapper.OpenStu(id);
    }

    @Override
    public void CloseStu(Integer id) {
        studentMapper.CloseStu(id);
    }

    @Override
    public PageInfo<Student> QLike(Integer pageNum,String name) {
        //设置分页信息
        PageHelper.startPage(pageNum,5);
        List<Student> StuList=studentMapper.QLike(name);
        PageInfo<Student> pageInfo=new PageInfo<Student>(StuList);
        return pageInfo;
    }
}
