package com.service;

import com.domain.Books;

import java.util.List;

public interface IBooksService {
    public List<Books> findAll(Integer page,Integer size);
    public void save(Books book);
    public Books findById(Integer id);

    void update(Books book);

    void updateStatuById(Integer id);

    List<Books> findMyBookAll(Integer page,Integer size);

    void deleteMyBooks(Integer id);
}
