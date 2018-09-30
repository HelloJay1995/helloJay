package cn.hello.jay.service;

import cn.hello.jay.mapper.UserMapperExt;
import cn.hello.jay.model.po.Appointment;
import cn.hello.jay.model.po.User;
import cn.hello.jay.model.vo.LoginResponse;
import cn.hello.jay.util.MD5Util;
import cn.hello.jay.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapperExt userMapper;

    /**
     * 用户注册
     *
     * @param user
     */
    public void register(User user) {
        user.setPassword(MD5Util.md5Encode(user.getPassword()).toLowerCase());
        LoginResponse response = RequestUtil.login(user.getName(), user.getPassword());
        if (response != null && !StringUtils.isEmpty(response.getJszh())) {
            user.setJszh(response.getJszh());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insertSelective(user);
        }
    }

    /**
     * 查询有效用户
     *
     * @return
     */
    public List<User> listEffectiveUser() {
        Map<String, Object> params = new HashMap<>();
        params.put("isDeleted", 0);
        return userMapper.listUserByMap(params);
    }

    /**
     * 查询被删除用户
     *
     * @return
     */
    public List<User> listSusUser() {
        Map<String, Object> params = new HashMap<>();
        params.put("isDeleted", 1);
        return userMapper.listUserByMap(params);
    }
}
