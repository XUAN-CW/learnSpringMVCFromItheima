package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Result;
import domain.User;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    //    @Test
    //插入操作
    public void save(Result result) throws IOException {

        //模拟user对象
//        Result result = new Result();
        //不改代码就运行，第二此运行时会报错，因为 id 为主键
//        result.setId(47);
//        result.setAvg_integral(123);
//        result.setAvg_remaining(456);

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//在此设置为 true ，后面就不用手动提交
        //执行操作  参数：namespace+id
        sqlSession.insert("userMapper.save",result);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //    @Test
    //查询一个对象
    public List<User> findById(int id) throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findById",id);

//        User user = sqlSession.selectOne("userMapper.findById", 1);
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
        return userList;
    }


    //http://localhost:8080/user/quick3?id=123456789
    @RequestMapping(value="/quick3")
    public ModelAndView save3(int id,ModelAndView modelAndView) throws IOException {
        List<User> userList = findById(id);
        Result result = new Result();
        int biggest=-99999;
        int least=999999;
        int avg_integral = 0;
        for (User user:userList){
            least = Math.min(user.getIntegral(), least);
            biggest = Math.max(user.getIntegral(), biggest);
            avg_integral+=user.getRemaining();
        }

        result.setId(id);
        result.setMin(least);
        result.setMax(biggest);

        save(result);



        modelAndView.addObject("username",userList.toString());
        modelAndView.addObject("remaining",avg_integral);
        modelAndView.addObject("min",least);
        modelAndView.addObject("max",biggest);

        modelAndView.setViewName("success");


        return modelAndView;
    }

}
