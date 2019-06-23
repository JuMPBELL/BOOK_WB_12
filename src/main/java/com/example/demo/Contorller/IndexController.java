package com.example.demo.Contorller;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.SQLMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.hutool.core.util.ObjectUtil;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class IndexController {
    @Autowired
    private SQLMapper sqlMapper;

    @GetMapping(value = {"/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getSession().getAttribute("user");
        if (ObjectUtil.isNull(user)) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("page/index");
            mv.addObject("msg","用户"+user.getUsername()+"登陆成功");
            List<Book> bookslist = sqlMapper.findBook();
            System.out.println(bookslist);
            mv.addObject("books",bookslist);
            mv.addObject(user);
        }
        return mv;
    }


}
