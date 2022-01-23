package zzfree.controller;

import com.alibaba.spring.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import zzfree.entity.Category;
import zzfree.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zzfree.utils.JSONUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2022-01-22 16:00:14
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    //类别列表
    @GetMapping
    public List<Category> categories(){
        return categoryService.queryByFirstLevel();

//        return null;
    }

    //修改类别
    @PatchMapping("/{id}")  //{"name":"",""parentid:""}
        public Category update( @PathVariable("id") Integer id ,@RequestBody Category category){
        logger.info("更新的类别id"+id);
        logger.info("更新的类别信息:"+ JSONUtils.writeJSON(category));
        //1.更新
        category.setId(id);
        return categoryService.update(category);
        }

    //添加类别
    @PostMapping
    public Category save(@RequestBody Category category){
        logger.info("更新的类别信息:"+ JSONUtils.writeJSON(category));
        return categoryService.insert(category);
    }

     //删除类别
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        logger.info("要删除的ID"+id);
//        Date now = new Date();
//        categoryService.update()
        categoryService.deleteById(id);
    }


    }





