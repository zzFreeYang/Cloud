package zzfree.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(User)实体类
 *
 * @author makejava
 * @since 2022-01-09 22:40:48
 */
public class User implements Serializable {
    private static final long serialVersionUID = 283584333643599688L;
    
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 头像链接
     */
    private String avatar;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String showname;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deketedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeketedAt() {
        return deketedAt;
    }

    public void setDeketedAt(Date deketedAt) {
        this.deketedAt = deketedAt;
    }

}

