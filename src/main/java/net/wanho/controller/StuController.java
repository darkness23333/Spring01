package net.wanho.controller;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import net.wanho.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Map;

/**
 * Created by fenzx on 2019/5/28.
 */
@Controller
@RequestMapping("stu")
public class StuController {
    @Autowired
    private StudentServiceI studentServiceI;

    @RequestMapping("StuList")
    public String GoStuList(){
        return "StuList";
    }

    @RequestMapping("AllStuList")
    public String AllStuList(@RequestParam(value = "pageNum",defaultValue = "1")  Integer pageNum , Map map){

        PageInfo<Student> pageInfo = studentServiceI.queryAll(pageNum);
        map.put("PageInfo", pageInfo);
        return "StuList";
    }

    @RequestMapping("deleteStu")
    public String deleteStu(Integer id){
        studentServiceI.delStuById(id);
        return "redirect:/stu/AllStuList";
    }

    @RequestMapping("addstu")
    public String addstu(Date date,String name, String sex, Integer age, String className){
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);

        Student student=new Student(null,name,sex,age,className,1,Date.valueOf(createdate),null);
        studentServiceI.AddStu(student);
        return "redirect:/stu/AllStuList";
    }

    @RequestMapping("GoUpdate")
    public String GoUpdate(String id,Map map){
       Student student= studentServiceI.queryStuById(Integer.parseInt(id));
        map.put("QStu",student);
        return "UpdateStu";
    }

    @RequestMapping("UpdateStu")
    public String UpdateStu(Student student){
       studentServiceI.updateStuById(student);
        return "redirect:/stu/AllStuList";
    }

    @RequestMapping("OpenStu")
    public String OpenStu(String id){
        studentServiceI.OpenStu(Integer.parseInt(id));
        return "redirect:/stu/AllStuList";
    }

    @RequestMapping("CloseStu")
    public String CloseStu(String id){
        studentServiceI.CloseStu(Integer.parseInt(id));
        return "redirect:/stu/AllStuList";
    }

    @RequestMapping("QLike")
    public String QLike(@RequestParam(value = "pageNum",defaultValue = "1")  Integer pageNum , Map map,String search){
        /*System.out.println("获取数据："+search);*/
        PageInfo<Student> pageInfo=studentServiceI.QLike(pageNum,search);
        map.put("PageInfo", pageInfo);
        return "StuList";
    }


    @RequestMapping("jsonResult")
    @ResponseBody
    public JsonResult Test(Student student){
        student.setId(1);
        student.setName("fzx");
        student.setSex("男");
        student.setAge(22);
        student.setClassName("java127");
        JsonResult jsonResult=new JsonResult(200,"成功",student);
        return jsonResult;
    }



    @RequestMapping("GoUpload")
    public String GoUpload(){
        return "upload";
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file, String desc, HttpServletRequest request){
        System.out.println("desc:"+desc);
        System.out.println("file:"+file.getOriginalFilename());

        try {
            //输入流
            InputStream inputStream=file.getInputStream();





        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
