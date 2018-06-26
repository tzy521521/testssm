package com.tzy777.testssm.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table book
 *
 * @mbg.generated do_not_delete_during_merge 该注释于2018年06月26日15时45分59秒生成
 */
public class Book {
    /**
     * Database Column Remarks:
     *   图书ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.book_id
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    private Long bookId;

    /**
     * Database Column Remarks:
     *   图书名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.name
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    private String name;

    /**
     * Database Column Remarks:
     *   馆藏数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.number
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    private Integer number;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    public Book(Long bookId, String name, Integer number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.book_id
     *
     * @return the value of book.book_id
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.name
     *
     * @return the value of book.name
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.number
     *
     * @return the value of book.number
     *
     * @mbg.generated 该注释于2018年06月26日15时45分59秒生成
     */
    public Integer getNumber() {
        return number;
    }
}