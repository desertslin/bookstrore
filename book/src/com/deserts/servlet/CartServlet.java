package com.deserts.servlet;

import com.deserts.bean.Book;
import com.deserts.bean.Cart;
import com.deserts.bean.CartItem;
import com.deserts.service.BookService;
import com.deserts.service.impl.BookServiceImpl;
import com.deserts.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @ClassName CartServlet
 * @Description TODO
 * @Author deserts
 * @Date 2020/9/26 16:53
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的id，并封装成对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //根据对象的id查出完整的信息
        Book one = bookService.getOne(book);
        //根据书的信息，创建商品项
        CartItem item = new CartItem(one.getId(), one.getTitle(), 1, new BigDecimal(one.getPrice()), new BigDecimal(one.getPrice()));
        //添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(item);
        request.getSession().setAttribute("lastName", item.getName());
        //重定向到商品列表页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的id
        Integer id = Integer.parseInt(request.getParameter("id"));
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.delete(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的id
        Integer id = Integer.parseInt(request.getParameter("bId"));
        //获取修改后的数量
        Integer count = Integer.parseInt(request.getParameter("count"));
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            cart.updateCount(id, count);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }
}
