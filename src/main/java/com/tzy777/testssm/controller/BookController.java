package com.tzy777.testssm.controller;

import com.tzy777.testssm.dto.AppointExecution;
import com.tzy777.testssm.dto.Result;
import com.tzy777.testssm.entity.Book;
import com.tzy777.testssm.enums.AppointStateEnum;
import com.tzy777.testssm.exception.NoNumberException;
import com.tzy777.testssm.exception.RepeatAppointException;
import com.tzy777.testssm.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 14:32
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId")Long bookId,Model model){
        if (bookId==null){
            return "redirect:/book/list";
        }else {
            Book book =bookService.getById(bookId);
            if (book == null) {
                return "forward:/book/list";
            }
            model.addAttribute("book", book);
            return "detail";
        }
    }

    @RequestMapping(value = "/{bookId}/appoint",method = RequestMethod.POST,produces = {"application/json;charset=utf-8" })
    @ResponseBody
    private Result<AppointExecution> appoint(
            @PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.toString().equals("")) {
            return new Result<>(false, "学号不能为空");
        }
        AppointExecution execution=null;
        try {
            execution = bookService.appoint(bookId,studentId);
        }catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }
}
