package com.wuning.service.impl;

import com.wuning.dao.BookDao;
import com.wuning.dao.impl.BookDaoImpl;
import com.wuning.pojo.Book;
import com.wuning.pojo.Page;
import com.wuning.service.BookService;

import java.util.List;

/**
 * @author wu
 * @date 2020-04-21 14:50
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);

    }

    @Override
    public Book queryBookId(Integer id) {

        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageToal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageToal += 1;
        }
        page.setPageToal(pageToal);
        page.setPageNO(pageNo);
        int begin = (page.getPageNO() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageToal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageToal += 1;
        }
        page.setPageToal(pageToal);
        page.setPageNO(pageNo);
        int begin = (page.getPageNO() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
