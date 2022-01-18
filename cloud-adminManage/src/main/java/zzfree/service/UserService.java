package zzfree.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import zzfree.entity.User;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;


/**
 * 用户(User)表服务接口
 *
 * @author makejava
 * @since 2022-01-09 22:40:50
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);
}
