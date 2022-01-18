package zzfree.controller;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import zzfree.dto.UserDTO;
import zzfree.entity.User;
import zzfree.service.UserService;
import org.springframework.web.bind.annotation.*;
import zzfree.utils.JSONUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户(User)表控制层
 *
 * @author makejava
 * @since 2022-01-09 22:48:48
 */
@RestController
//@RequestMapping("user")   // 自动声明去掉,这样下面的tokends可以直接访问了
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private RedisTemplate  RedisTemplate;
    @Autowired
    public UserController(UserService userService , RedisTemplate redisTemplate) {
        this.userService = userService;
        RedisTemplate = redisTemplate;
    }


    //
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token){
        RedisTemplate.setKeySerializer(new StringRedisSerializer());
        RedisTemplate.delete(token);
    }



    //已登录用户信息
    @GetMapping("/admin-user")
    public UserDTO user(String token){
        logger.info("当前token信息"+token);
        RedisTemplate.setKeySerializer(new StringRedisSerializer());
         User user = (User) RedisTemplate.opsForValue().get(token);
         UserDTO userDTO = new UserDTO(user.getName(),user.getAvatar());
//        BeanUtils.copyProperties(user,userDTO);  // 2.属性复制做法
         return userDTO;
    }


    //用户登录
    @PostMapping("/tokens")
    public Map<String,String> tokens(@RequestBody User user,HttpSession session) throws JsonProcessingException {
        Map result = new HashMap();
      logger.info("接收到的user："+ JSONUtils.writeJSON(user));  //object转json
        //1.登陆
        User userDB = userService.login(user);
        //2.登录成功,存入 redis
        String token = session.getId();
        RedisTemplate.setKeySerializer(new StringRedisSerializer());
        RedisTemplate.opsForValue().set(token,userDB,30, TimeUnit.MINUTES);
        result.put("toekn",token);
        return  result;
    }





}

