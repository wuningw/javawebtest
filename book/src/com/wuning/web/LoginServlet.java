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
 * @date 2020-04-18 18:32
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if(login==null){
            req.setAttribute("msg","用户或者密码错误!");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
