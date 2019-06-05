package net.wanho.mapper;

import net.wanho.pojo.Student;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by fenzx on 2019/5/28.
 */
public interface StudentMapper {

    List<Student> queryAll();

    void AddStu(Student student);

    void updateStuById(Student student);

    void delStuById(Integer id);

    Student queryStuById(Integer id);

    void OpenStu(Integer id);

    void CloseStu(Integer id);

    List<Student> QLike(String name);


}
