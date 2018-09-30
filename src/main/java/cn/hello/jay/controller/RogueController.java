package cn.hello.jay.controller;

import cn.hello.jay.service.RogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rogue")
public class RogueController {

    @Autowired
    private RogueService rogueService;

    @ResponseBody
    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String start() {
        rogueService.rogue();
        return "start";
    }


}
