package zzfree.service.impl;

import com.alibaba.druid.util.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import zzfree.entity.User;
import zzfree.dao.UserDao;
import zzfree.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * 用户(User)表服务实现类
 *
 * @author makejava
 * @since 2022-01-09 22:56:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }


    @Override
    public User login(User user) {
        //1.根据用户名查询用户
        User userDB = userDao.findByUserName(user.getName());
        //2.判断
        if(ObjectUtils.isEmpty(userDB)){
            throw new RuntimeException("用户名错误");
        }
//        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        String password = user.getPassword();
        if(!StringUtils.equals(password,userDB.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return userDB;
//        return null;
    }
}
