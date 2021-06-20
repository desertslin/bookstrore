package com.deserts.servlet;

import com.deserts.bean.Book;
import com.deserts.bean.Page;
import com.deserts.service.BookService;
import com.deserts.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CilentBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    /**
     * 处理分页显示的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        Page<Book> page = bookService.getPage(pn, "4");
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String min = request.getParameter("min");
        String max = request.getParameter("max");
        request.setAttribute("min", min);
        request.setAttribute("max", max);
        String pn = request.getParameter("pn");
        Page<Book> page = bookService.getPageByPrice(pn, "4", min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
