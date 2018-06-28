package com.tzy777.testssm.service.impl;

import com.tzy777.testssm.dao.AppointmentMapper;
import com.tzy777.testssm.dao.BookMapper;
import com.tzy777.testssm.dto.AppointExecution;
import com.tzy777.testssm.entity.Appointment;
import com.tzy777.testssm.entity.Book;
import com.tzy777.testssm.enums.AppointStateEnum;
import com.tzy777.testssm.exception.AppointException;
import com.tzy777.testssm.exception.NoNumberException;
import com.tzy777.testssm.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 12:02
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Book getById(Long bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookMapper.selectAll();
    }

    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    @Override
    @Transactional
    public AppointExecution appoint(Long bookId, Long studentId) {
        try {
            // 减库存
            int update = bookMapper.reduceNumber(bookId);
            if (update <= 0) {
                throw new NoNumberException("no number");
            }else {
                // 执行预约操作
                int insert = appointmentMapper.insertAppointment(bookId,studentId,new Date());
                if (insert<=0){
                    throw new RuntimeException("repeat appoint");
                }else {
                    Appointment appointment=appointmentMapper.selectByPrimaryKey(bookId,studentId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
                }
            }
            // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
        }catch (NoNumberException e1){
            throw e1;
        }catch (RuntimeException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
