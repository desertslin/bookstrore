package com.deserts.service;

import com.deserts.bean.Book;
import com.deserts.bean.Page;

import java.nio.file.Path;
import java.util.List;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/15 12:53
 */
public interface BookService {
    /**
     * 添加一本图书
     * @param book 要添加的图书
     * @return 若为true，则添加成功
     */
    public boolean add(Book book);

    /**
     * 删除一本图书
     * @param book 要删除的图书
     * @return 若为true，则删除成功
     */
    public boolean delete(Book book);

    /**
     * 修改一本图书
     * @param book 要修改的图书
     * @return 若为true，则修改成功
     */
    public boolean update(Book book);

    /**
     * 查询一本图书
     * @param book 要查询的图书
     * @return Book
     */
    public Book getOne(Book book);

    /**
     * 查询所有图书
     * @return List<Book></Book>
     */
    public List<Book> getAll();

    /**
     * 分页查找出的图书
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> getPage(String pageNo, String pageSize);

    public Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice);

    public int getTotalCountByPrice(String minPrice, String maxPrice);
}
