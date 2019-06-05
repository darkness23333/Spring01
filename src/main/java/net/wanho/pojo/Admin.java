package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by fenzx on 2019/6/4.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
}
