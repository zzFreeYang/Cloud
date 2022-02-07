package zzfree.service;

import zzfree.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 文章(Article)表服务接口
 *
 * @author makejava
 * @since 2022-02-05 15:36:15
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 分页查询
     *
     * @param article 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Article> queryByPage(Article article, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 条件分页查询
     * @param offset 起始位置
     * @param limit 每页显示记录数
     * @param id  视频id
     * @param name 视频名称
     * @param categoryId 类别id
     * @param username   用户名
     */
    List<Article> findAllByKeywords(int offset, int limit, String id, String name, String categoryId, String username);

    /**
     *
     * @param id  视频id
     * @param name 视频名称
     * @param categoryId 类别id
     * @param username   用户名
     * @return 条件符合条数
     */
    Long findTotalCountsByKeywords(String id, String name, String categoryId, String username);
}
