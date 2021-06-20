package com.deserts.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName ManagerFilter
 * @Description TODO
 * @Author deserts
 * @Date 2020/9/29 14:15
 */
public class ManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
