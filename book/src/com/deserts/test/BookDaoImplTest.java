package com.deserts.test;

import com.deserts.bean.Book;
import com.deserts.dao.BookDao;
import com.deserts.dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoImplTest {
    BookDao dao = new BookDaoImpl();

    @Test
    void getPageListByPrice() {
        List<Book> list = dao.getPageListByPrice(1, 4, 50, 150);
        System.out.println(list.toString());
    }

    @Test
    void getTotalCountByPrice() {
        int count = dao.getTotalCountByPrice(30, 200);
        System.out.println(count);
    }
}