package zzfree.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 分类(Category)实体类
 *
 * @author makejava
 * @since 2022-01-22 16:00:25
 */
@JsonInclude(JsonInclude.Include.NON_NULL) //用在类上，用来指定json数据包含哪些数据   NON_NULL只要不为空的数据
public class Category implements Serializable {
    private static final long serialVersionUID = 778128655703191163L;
    
    private Integer id;
    
    private Integer parentid;
    /**
     * 分类名
     */
    private String name;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deketedAt;

    private List<Category> childeren;


    public List<Category> getChilderen() {
        return childeren;
    }

    public void setChilderen(List<Category> childeren) {
        this.childeren = childeren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

