package com.example.demo.API;

import com.example.demo.Mapper.SQLMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class UpdateAPI {
    @Autowired
    private SQLMapper sqlMapper;


    @PostMapping("/update")
    public Boolean updatebook(@Param("id") int id) {
        return sqlMapper.updatebook(id);
    }
}
