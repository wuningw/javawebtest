package com.wuning.web;

import com.google.gson.Gson;
import com.wuning.pojo.User;
import com.wuning.service.UserService;
import com.wuning.service.impl.UserServiceImpl;
import com.wuning.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author wu
 * @date 2020-04-20 21:51
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    protected void ajaxUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);
        Gson gson = new Gson();
        String josn = gson.toJson(resultMap);
        resp.getWriter().write(josn);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if (login == null) {
            req.setAttribute("msg", "用户或者密码错误!");
            req.setAttribute("username", username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                System.out.println("用户名[" + username + "]已经存在");
                req.setAttribute("msg", "用户名已经存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码不可用");
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
