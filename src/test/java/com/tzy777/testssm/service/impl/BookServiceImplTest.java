package com.tzy777.testssm.service.impl;

import com.tzy777.testssm.BaseTest;
import com.tzy777.testssm.dto.AppointExecution;
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
        Long bookId=1001L;
        Book book=bookService.getById(bookId);
        System.out.println(book);
    }

    @Test
    public void appoint(){
        Long bookId=1000L;
        Long studentId=52653512L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}