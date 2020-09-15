package com.wuning.web;

import com.wuning.pojo.User;
import com.wuning.service.UserService;
import com.wuning.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wu
 * @date 2020-04-18 16:43
 */
public class RigistServlet extends HttpServlet {
    private UserService userService= new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcd".equalsIgnoreCase(code)) {
            if(userService.existUsername(username)){
                System.out.println("用户名["+username+"]已经存在");
                req.setAttribute("msg","用户名已经存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            System.out.println("验证码不可用");
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
           req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}
