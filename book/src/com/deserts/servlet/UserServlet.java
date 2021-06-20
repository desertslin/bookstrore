package com.deserts.servlet;

import com.deserts.bean.User;
import com.deserts.service.UserService;
import com.deserts.service.impl.UserServiceImpl;
import com.deserts.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    protected UserService service = new UserServiceImpl();

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 Session 中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session 中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        // 2、检查 验证码是否正确 === 写死,要求验证码为:abcde
        if (token == null || !(token.equalsIgnoreCase(code))) {
            //验证码错误跳回注册页面,回显错误信息
            request.setAttribute("msg", "验证码输入错误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        } else {
            // 3、检查 用户名是否可用
            if (service.existsUsername(username)) {
                //用户名已存在，返回注册页面,回显错误信息
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //用户名不存在，注册成功，将数据保存到数据库
                service.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //验证用户名和密码是否正确
        if (service.login(user) != null) {
            //将用户名保存到session域中，用于登录后显示用户名
            request.getSession().setAttribute("username", user.getUsername());
            //正确跳转到成功页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            //错误回到登录页面
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁Session中的用户信息
        request.getSession().invalidate();
        // 2.重定向到首页
        response.sendRedirect(request.getContextPath());
    }

}
