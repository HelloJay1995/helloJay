package cn.hello.jay.mapper;

import cn.hello.jay.model.po.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface UserMapperExt extends UserMapper {

    List<User> listUserByMap(Map<String,Object> params);

    int updateAllNotDeleted();
}