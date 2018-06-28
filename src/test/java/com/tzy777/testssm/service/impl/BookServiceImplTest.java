package com.tzy777.testssm.service.impl;

import com.tzy777.testssm.BaseTest;
import com.tzy777.testssm.entity.Book;
import com.tzy777.testssm.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 12:08
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getById() {
        long bookId=1001;
        Book book=bookService.getById(bookId);
        System.out.println(book);
    }
}