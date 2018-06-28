package com.tzy777.testssm.dao;

import com.tzy777.testssm.BaseTest;
import com.tzy777.testssm.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 10:59
 */
public class BookMapperTest extends BaseTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void selectByPrimaryKey() {
        long bookId=1000;
        Book book=bookMapper.selectByPrimaryKey(bookId);
        System.out.println(book);
    }

    @Test
    public void reduceNumber(){
        long bookId=1000;
        int number=bookMapper.reduceNumber(bookId);
        System.out.println(number);
    }
}