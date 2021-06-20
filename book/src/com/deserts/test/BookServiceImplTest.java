package com.deserts.test;

import com.deserts.bean.Book;
import com.deserts.bean.Page;
import com.deserts.service.BookService;
import com.deserts.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.Servlet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    BookService service = new BookServiceImpl();
    @Test
    void getPage() {

        Page<Book> page = service.getPage("2", "4");
        List<Book> data = page.getPageData();
        for (Book b: data){
            System.out.println(b);
        }
    }

    @Test
    void getPageByPrice() {
        Page<Book> page = service.getPageByPrice("1", "4", "50", "200");
        System.out.println(page.getPageData());
    }

    @Test
    void getTotalCountByPrice() {
        int count = service.getTotalCountByPrice("30", "200");
        System.out.println(count);
    }
}