package cn.hello.jay.practice.dubbo.provider;

import cn.hello.jay.practice.dubbo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

/**
 * @author 周健以
 * @Date 2019年05月14日
 */
@Service
public class UserServiceImpl implements UserFacade {
    @Override
    public User save(User user) {
        user.setId(1);
        System.out.println(JSON.toJSONString(user));
        return user;
    }
}
