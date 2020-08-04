package com.hbsi.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lbq
 * @date 2020 08  18:08
 */
//@Api(注解)
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名")
    public  String username;
   public  String password;
}
