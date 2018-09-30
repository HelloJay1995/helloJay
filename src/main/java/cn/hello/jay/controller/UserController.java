package cn.hello.jay.controller;

import cn.hello.jay.model.po.User;
import cn.hello.jay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(@RequestParam String name, @RequestParam String password) {
        User user = new User(name, password);
        userService.register(user);
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "success", method = RequestMethod.GET)
    public List<User> listAllUser() {
        return userService.listSusUser();
    }
}
