package com.service;

import com.dao.IBooksDao;
import com.dao.IUsersDao;
import com.domain.Books;
import com.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BooksServiceImpl implements IBooksService {
    @Autowired
    private IBooksDao dao;
    @Autowired
    private IUsersDao usersDao;

    @Override
    public List<Books> findAll(Integer page,Integer size) {

        PageHelper.startPage(page, size);
        return dao.findAll();
    }

    @Override
    public void save(Books book) {
        dao.save(book);
    }

    @Override
    public Books findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void update(Books book) {
       dao.update(book);
    }


    @Override
    public void updateStatuById(Integer id) {
        SecurityContext context= SecurityContextHolder.getContext();//从上下文获取当前操作的用户
        User user= (User) context.getAuthentication().getPrincipal();
        //获取当前用户名
        String username= user.getUsername();
        UserInfo userInfo=usersDao.findByUsername(username);
       if(dao.findByBooksAndUsersId(id)==null) {
           dao.updateStatuById(id);
           dao.insertbooksAndUsers(id, userInfo.getId());
       }
    }

    @Override
    public List<Books> findMyBookAll(Integer page,Integer size) {
        SecurityContext context= SecurityContextHolder.getContext();
        User user= (User) context.getAuthentication().getPrincipal();
        String username=user.getUsername();
        UserInfo userInfo=usersDao.findByUsername(username);
        Integer userId=userInfo.getId();
        PageHelper.startPage(page, size);
        return dao.findMyBookAll(userId);
    }

    @Override
    public void deleteMyBooks(Integer id) {
        dao.deleteMyBooks(id);
        dao.updateStatu1ById(id);
    }
}
