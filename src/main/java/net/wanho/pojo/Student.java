package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by fenzx on 2019/5/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String className;
    private Integer status;
    private Date creationTime;
    private Date updateTime;
}
