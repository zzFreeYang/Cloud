package zzfree.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zzfree.entity.User;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 根据条件分页查询
     */
    List<User> findAllByKeywords(@Param("offset") int offset, @Param("limit") int limit, @Param("id") String id, @Param("name") String name, @Param("phone") String phone);

    /**
     * 根据条件查询总条数
     */
    Long findTotalCountsByKeywords(@Param("id") String id, @Param("name") String name, @Param("phone") String phone);

}