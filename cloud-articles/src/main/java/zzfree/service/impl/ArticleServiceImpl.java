package zzfree.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zzfree.entity.Article;
import zzfree.dao.ArticleDao;
import zzfree.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章(Article)表服务实现类
 *
 * @author makejava
 * @since 2022-02-05 15:36:18
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Integer id) {
        return this.articleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param article 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Article> queryByPage(Article article, PageRequest pageRequest) {
        long total = this.articleDao.count(article);
        return new PageImpl<>(this.articleDao.queryAllByLimit(article, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article insert(Article article) {
        this.articleDao.insert(article);
        return article;
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article update(Article article) {
        this.articleDao.update(article);
        return this.queryById(article.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleDao.deleteById(id) > 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAllByKeywords(int offset, int limit, String id, String name, String categoryId, String username) {
        int start = (offset - 1) * limit;
        return articleDao.findAllByKeywords(start, limit, id, name, categoryId, username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotalCountsByKeywords(String id, String name, String categoryId, String username) {
        return articleDao.findTotalCountsByKeywords(id, name, categoryId, username);
    }


}
