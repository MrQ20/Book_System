package com.dao;

import com.domain.Books;
import com.domain.Books_Users;
import org.apache.ibatis.annotations.*;

        import java.util.List;

public interface IBooksDao {
    @Select("select * from books")
    public List<Books> findAll();
    @Insert("insert into books(bookName,author,publishTime,statu)values(#{bookName},#{author},#{publishTime},#{statu})")
    public void save(Books book);
    @Select("select * from books where id=#{id}")
    public Books findById(Integer id);
    @Update("update books set bookName=#{bookName},author=#{author},publishTime=#{publishTime},statu=#{statu} where id=#{id}")
    void update(Books book);
    @Update("update  books set statu=0 where id=#{id}")
    void updateStatuById(Integer id);
    @Insert("insert into books_users(bookId,userId)values(#{bookId},#{userId})")
    void insertbooksAndUsers(@Param("bookId") Integer id,@Param("userId") Integer id1);
    @Select("select * from books_users where bookId=#{bookId}")
    Books_Users findByBooksAndUsersId(@Param("bookId") Integer bookId);

    @Select("select id,bookName from books where id in(select bookId from books_users where userId=#{userId})")
    List<Books> findMyBookAll(Integer userId);
    @Delete("delete from books_users where bookId=#{id}")
    void deleteMyBooks(Integer id);

    @Update("update books set statu=1 where id=#{id}")
    void  updateStatu1ById(Integer id);
}