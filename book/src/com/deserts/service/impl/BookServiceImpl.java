package com.deserts.service.impl;

import com.deserts.bean.Book;
import com.deserts.bean.Page;
import com.deserts.dao.BookDao;
import com.deserts.dao.impl.BookDaoImpl;
import com.deserts.service.BookService;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/15 12:58
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean add(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean delete(Book book) {
        return bookDao.deleteBook(book);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book getOne(Book book) {
        return bookDao.getBook(book);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAllBook();
    }

    @Override
    public Page<Book> getPage(String pageNo, String pageSize) {
        Page<Book> page = new Page<>();
        int pn = 1;
        int ps = page.getPageSize();
        try {
            pn = Integer.parseInt(pageNo);
            ps = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {

        }
        int totalCount = bookDao.getTotalCount();
        page.setTotalCount(totalCount);
        page.setPageNo(pn);
        page.setPageSize(ps);
        List<Book> list = bookDao.getPageList(page.getIndex(), ps);
        page.setPageData(list);
        return page;
    }

    @Override
    public Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice) {
        double min = 0;
        double max = Double.MAX_VALUE;
        try {
            min = Double.parseDouble(minPrice);
            max = Double.parseDouble(maxPrice);
        } catch (NumberFormatException e) {

        }
        Page<Book> page = new Page<>();
        int pn = 1;
        int ps = page.getPageSize();
        try {
            pn = Integer.parseInt(pageNo);
            ps = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {

        }
        int totalCount = bookDao.getTotalCountByPrice(min, max);
        page.setTotalCount(totalCount);
        page.setPageNo(pn);
        page.setPageSize(ps);
        List<Book> list = bookDao.getPageListByPrice(page.getIndex(), ps, min, max);
        page.setPageData(list);
        return page;
    }

    @Override
    public int getTotalCountByPrice(String minPrice, String maxPrice) {
        double min = 0;
        double max = Double.MAX_VALUE;
        try {
            min = Double.parseDouble(minPrice);
            max = Double.parseDouble(maxPrice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int count = bookDao.getTotalCountByPrice(min, max);
        return count;
    }
}
