package com.hbsi.swagger.controller;

import com.hbsi.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author lbq
 * @date 2020 08  16:09
 */
@ApiOperation("hello控制类")   //接口
@RestController
public class HelloController {


    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }

  //只要我们的接口中，返回值中存在实体类   他就会被swagger扫描到
    @PostMapping(value="/user")
    public User user(@RequestBody User user){
        return new User();
    }
    @ApiOperation("hello控制类")  //不放在类上  放在方法上
    @GetMapping(value="/hello2")
    public String hello2(@ApiParam("用户名") String username)
    {
        return "hello"+username;
    }
}
