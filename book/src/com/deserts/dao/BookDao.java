package com.deserts.dao;

import com.deserts.bean.Book;

import java.util.List;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/15 11:26
 */
public interface BookDao {
    /**
     * 查询所有的图书
     * @return List<Book>
     */
    public List<Book> getAllBook();

    /**
     * 添加图书
     * @param book  要添加的图书
     * @return 若为true，则添加成功
     */
    public boolean  addBook(Book book);

    /**
     * 删除图书
     * @param book  要删除的图书
     * @return 若为true，则添加成功
     */
    public boolean  deleteBook(Book book);

    /**
     * 修改图书
     * @param book  修改后的图书
     * @return  若为true，则修改成功
     */
    public boolean  updateBook(Book book);

    /**
     * 查询单本图书
     * @param book  要查询的图书
     * @return Book
     */
    public Book  getBook(Book book);

    /**
     * 分页查询的数据
     * @param index
     * @param size
     * @return
     */
    public List<Book> getPageList(int index, int size);

    /**
     * 获取总记录数
     * @return
     */
    public int getTotalCount();

    /**
     * 获取按照价格分页的数据
     * @param index
     * @param size
     * @param min
     * @param max
     * @return
     */
    public List<Book> getPageListByPrice(int index, int size, double min, double max);

    /**
     * 获取按价格查找的总记录数
     * @param min
     * @param max
     * @return
     */
    public int getTotalCountByPrice(double min, double max);
}
