package com.example.demo.Mapper;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SQLMapper {

    @Select("SELECT id FROM user")
    int findid();
    @Select("SELECT * FROM user where username=#{username} and password=#{password}")
    User findUser(@Param("username") String username,@Param("password") String password);
    @Select("SELECT * FROM book")
    List<Book> findBook();
    @Update("Update Book set book_sum = book_sum-1 where book_id=#{id}")
    Boolean updatebook(@Param("id") int id);
}
