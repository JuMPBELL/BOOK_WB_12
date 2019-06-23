package com.example.demo.Contorller;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.SQLMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private SQLMapper SQLMapper;

    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        User u = SQLMapper.findUser(user.getUsername(),user.getPassword());
        ModelAndView mv = new ModelAndView();

        if (ObjectUtil.isNull(u)){
            mv.setViewName("page/login");
            mv.addObject("msg","用户"+user.getUsername()+"登陆失败");
        } else {
            mv.setViewName("redirect:/");
            request.getSession().setAttribute("user", user);
        }
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("page/login");
    }

    @GetMapping("/test")
    public String test() {
        int i = SQLMapper.findid();
        System.out.println(i);
        return "index";
    }

}