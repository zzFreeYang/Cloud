package zzfree.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import zzfree.entity.Article;
import zzfree.service.ArticleService;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章(Article)表控制层
 *
 * @author makejava
 * @since 2022-02-05 15:36:08
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;
    @GetMapping
    public Map<String,Object> articles(@RequestParam(value = "page" ,defaultValue = "1") Integer page,
                                       @RequestParam(value = "per_page",defaultValue = "5") Integer rows,
                                       String id,
                                       String name,
                                       @RequestParam(value = "category_id",required = false) String categoryId,
                                       @RequestParam(value = "uploader_name",required = false) String username
                                       ){
        Map<String,Object> result = new HashMap<>();
        logger.info("当前页"+page);
        logger.info("每页显示"+rows);
        logger.info("搜索条件name"+username);
        logger.info("搜索分类"+categoryId);

        Long totalCounts = articleService.findTotalCountsByKeywords(id,name,categoryId,username);

        List<Article> items = articleService.findAllByKeywords(page,rows,id,name,categoryId,username);
        result.put("total_count",totalCounts);
        result.put("items",items);
        return result;
    }



}

