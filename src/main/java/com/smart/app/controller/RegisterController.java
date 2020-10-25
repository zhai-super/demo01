package com.smart.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.smart.app.entity.User;
import com.smart.app.resp.BaseResponseEntity;
import com.smart.app.service.UserService;
import com.smart.app.service.impl.UserServiceImpl;
import com.smart.app.utils.ResponseUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * 协议号 + ip地址+端口 必须一致才不会跨域
 *
 *
 * get select
 * put update
 * delete
 * http://localhost:8080/api/user/register
 * post 请求 insert
 * Jackson
 * Fastjson
 * 写符合企业规范的代码
 */
public class RegisterController extends HttpServlet {
    // 后期该代码需要优化
    private UserService userService = new UserServiceImpl();

    /**
     * F7 进入方法
     * F8 执行下一行代码
     * F9 跳转下一个断点
     * 微服务    json
     * 前后端分离
     * <p>
     * fastjson
     * 参数校验
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException      返回json数据
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        String result;
        boolean isSuccess = userService.register(user);
        BaseResponseEntity<Boolean> entity = null;
        //json字符串
        if (isSuccess) {
            //将该对象转坏json
            entity = BaseResponseEntity.success(isSuccess);
//            json字符串
            /**
             * 解析成list对象
             * 要解析的json字符串
             */
//            List<User> users = JSONObject.parseArray("", User.class);
//            User user1 = JSONObject.parseObject("", User.class);
            // result=JSONObject.toJSONString(entity);
        } else {
            entity = BaseResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp, entity);
    }
}
