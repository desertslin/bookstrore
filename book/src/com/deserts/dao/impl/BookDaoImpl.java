package com.deserts.dao.impl;

import com.deserts.bean.Book;
import com.deserts.dao.BaseDao;
import com.deserts.dao.BookDao;

import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/15 11:31
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getAllBook() {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book";
        return queryBeanList(sql);
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "insert into bs_book(title,author,price,sales,stock,img_path) values (?,?,?,?,?,?)";
        int i = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        return i > 0;
    }

    @Override
    public boolean deleteBook(Book book) {
        String sql = "delete from bs_book where id = ?";
        return update(sql, book.getId()) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "update bs_book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        int i = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        return i > 0;
    }

    @Override
    public Book getBook(Book book) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where id = ?";
        return queryBean(sql, book.getId());
    }

    @Override
    public List<Book> getPageList(int index, int size) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book limit ?,?";
        return queryBeanList(sql, index, size);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from bs_book";
        Object o = querySingleValue(sql);
        int count = 0;
        try {
            count = Integer.parseInt(o.toString());
        } catch (NumberFormatException e) {

        }
        return count;
    }

    @Override
    public List<Book> getPageListByPrice(int index, int size, double min, double max) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where price between ? and ? order by price limit ?,?";
        return queryBeanList(sql, min, max, index, size);
    }

    @Override
    public int getTotalCountByPrice(double min, double max) {
        String sql = "select count(*) from bs_book where price between ? and ?";
        Object o = querySingleValue(sql, min, max);
        int count = 0;
        try {
            count = Integer.parseInt(o.toString());
        } catch (NumberFormatException e) {

        }
        return count;
    }
}
