package cn.weiyin.group07.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private Boolean isadmin;
    private Boolean isvalidate;
}
