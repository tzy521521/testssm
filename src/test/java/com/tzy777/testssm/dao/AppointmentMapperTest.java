package com.tzy777.testssm.dao;

import com.tzy777.testssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 14:05
 */
public class AppointmentMapperTest extends BaseTest {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    public void insertAppointment() {
        Long bookId=1001L;
        Long studentId=52653512L;
        int result = appointmentMapper.insertAppointment(bookId,studentId,new Date());
        System.out.println(result);
    }
}