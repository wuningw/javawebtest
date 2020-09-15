package com.wuning.test;

import com.wuning.pojo.Book;
import com.wuning.pojo.Page;
import com.wuning.service.BookService;
import com.wuning.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
 private BookService bookService= new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"哈皮妞学","舞动乾坤",new BigDecimal(99999),222222,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"哈皮妞学","舞动乾坤",new BigDecimal(9999),2222,0,null));
    }

    @Test
    public void queryBookId() {
        System.out.println(bookService.queryBookId(23));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){

        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,50,100));
    }
}