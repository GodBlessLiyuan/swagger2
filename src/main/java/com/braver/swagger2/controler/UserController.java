package com.braver.swagger2.controler;

import com.braver.swagger2.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description: api文档包括请求路径，请求头，请求参数（对象接收还是json接收），返回值类型字段，
 * @author: liyuan
 * @data 2020-12-07 17:53
 */
@RestController
@Api(tags = "用户数据接口")
public class UserController {
    //    好像可以定义返回类型，url
    @ApiOperation(value = "查询用户", notes = "根据id查询用户", response = String.class)
//    用于定义参数类型
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户id", required = true)
    @GetMapping("/user/{id}")
    public String getUserByID(@PathVariable Integer id) {
        return "/user" + id;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功!"),
            @ApiResponse(code = 500, message = "删除失败!")
    })
    @ApiOperation(value = "删除用户", notes = "通过id删除用户")
    //这是springmvc的删除
    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return id;
    }

    @ApiOperation(value = "添加用户", notes = "添加一个用户，传入用户名和地址")
    @ApiImplicitParams({
            //相当于定义了参数说明
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, defaultValue = "sang"),
            @ApiImplicitParam(paramType = "query", name = "address", value = "用户地址", required = true, defaultValue = "shenzhen")
    })
    @PostMapping("/user")
    public String addUser(@RequestParam String username, @RequestParam String address) {
        return username + address;
    }

    //    相当于api的操作注解
    @ApiOperation(value = "修改用户", notes = "修改用户，传入用户信息")
    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        return user.toString();
    }

    //    忽略，不生成文档
    @ApiIgnore
    @GetMapping("ignore")
    public void ignoreMethod() {
    }
}
