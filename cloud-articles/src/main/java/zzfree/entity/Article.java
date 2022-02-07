package zzfree.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章(Article)实体类
 *
 * @author makejava
 * @since 2022-02-05 15:36:12
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -43864429766257503L;
    
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 上传者ID
     */
    private Integer uid;
    /**
     * 封面链接
     */
    private String cover;
    /**
     * 文章链接
     */
    private String link;
    /**
     * 分类ID
     */
    private Integer categoryId;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;
    //===================  业务属性 ==================
    private String category;//类别
    private User uploader;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        return deletedAt;
    }

    public void setDeketedAt(Date deketedAt) {
        this.deletedAt = deketedAt;
    }

}

