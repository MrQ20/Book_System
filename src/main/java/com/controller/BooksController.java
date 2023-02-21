package com.controller;

import com.domain.Books;
import com.github.pagehelper.PageInfo;
import com.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private IBooksService service;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1",name = "page",required = true) Integer page,@RequestParam(defaultValue = "3",name = "size",required = true) Integer size){
        ModelAndView mv=new ModelAndView();

        List<Books> books=service.findAll(page,size);
        PageInfo pageInfo=new PageInfo(books);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("book-list");
        return mv;

    }
    @RequestMapping("/save")
    public String save(Books book){
        service.save(book);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        ModelAndView mv=new ModelAndView();
        Books book=service.findById(id);
        mv.addObject("book",book);
        mv.setViewName("book-update");
        return mv;
    }
    @RequestMapping("/update")
    public String update
            (@RequestParam(name = "id") Integer id, @RequestParam(name = "bookName") String bookName, @RequestParam(name = "author") String author, @RequestParam("publishTime")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date publishTime, @RequestParam("statu") Integer statu){
        Books book=service.findById(id);
        book.setAuthor(author);
        book.setBookName(bookName);
        book.setPublishTime(publishTime);
        book.setStatu(statu);
        service.update(book);
        return  "redirect:findAll";
    }
    @RequestMapping("/updateStatuById")
    public String updateStatuById(Integer id){
        service.updateStatuById(id);
        return "redirect:findAll";
    }
    @RequestMapping("/findMyBookAll")
    public ModelAndView findMyBookAll(@RequestParam(defaultValue = "1",name = "page",required = true) Integer page,@RequestParam(defaultValue = "3",name = "size",required = true) Integer size){
    ModelAndView modelAndView=new ModelAndView();
    List<Books> booksList= service.findMyBookAll(page,size);
    PageInfo pageInfo=new PageInfo(booksList);
       modelAndView.addObject("pageInfo",pageInfo);
               modelAndView.setViewName("mybook-list");
               return modelAndView;
               }
@RequestMapping("/deleteMyBook")
public String deleteMyBook(Integer id){
        service.deleteMyBooks(id);
        return "redirect:findMyBookAll";
        }

        }
