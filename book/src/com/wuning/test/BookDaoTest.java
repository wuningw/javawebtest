package com.wuning.test;

import com.wuning.dao.BookDao;
import com.wuning.dao.impl.BookDaoImpl;
import com.wuning.pojo.Book;
import com.wuning.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "吴宁娃", "wuning", new BigDecimal(99999), 222222, 0, null));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(23));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "吴宁传", "吴宁", new BigDecimal(99999), 222222, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
        System.out.println();
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(50,100));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,50,100)) {
            System.out.println(book);
        }
        System.out.println();
    }
}