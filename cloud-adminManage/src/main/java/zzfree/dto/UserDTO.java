package zzfree.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
private String name;
private  String avatar;



    public UserDTO(){   //todo 有参构造和无参构造

    }
    public UserDTO(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }
//    @JsonProperty("name")  //这个注解可以转换
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
