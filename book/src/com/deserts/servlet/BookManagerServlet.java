package com.deserts.servlet;

import com.deserts.bean.Book;
import com.deserts.bean.Page;
import com.deserts.service.BookService;
import com.deserts.service.impl.BookServiceImpl;
import com.deserts.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookManagerServlet extends BaseServlet {
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
        page.setUrl("manager/bookManagerServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
        /**
         * 处理显示所有图书列表的请求
         *
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从数据库中获取所有图书
        List<Book> list = bookService.getAll();
        //把图书的数据通过域对象传给jsp页面
        request.setAttribute("list", list);
        //转发页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 处理添加图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求中获取要添加的图书的信息
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //调用方法添加相应图书到数据库
        boolean b = bookService.add(book);
        //重定向到列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookManagerServlet?action=list");
    }

    /**
     * 处理删除图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        //获取id并封装成对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //调用方法从数据库中删除
        bookService.delete(book);
        //重定向到列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookManagerServlet?action=page&pn=" + pn);
    }

    /**
     * 获取要修改的图书并显示在页面上
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的id，并封装成对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //根据对象的id查出完整的信息
        Book one = bookService.getOne(book);
        //使用域对象将信息共享到jsp页面
        request.setAttribute("book", one);
        //转发完成数据的共享
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
     * 获取update请求的信息，根据id判断要添加还是修改，进行相应操作并转发回列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        //获取请求的id，并封装成对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //根据对象的id判断是要添加还修改，0为添加，大于0为修改
        if (book.getId() > 0){
            bookService.update(book);
        }else {
            bookService.add(book);
        }
        //将结果重定向到列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookManagerServlet?action=page&pn=" + pn);
    }
}
