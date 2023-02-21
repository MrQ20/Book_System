package com.domain;

import com.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
;

public class Books {
    private Integer id;
    private String bookName;
    private String  author;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date publishTime;
    private Integer statu;
    private String statuStr;
    private String publishTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getStatuStr() {
        if(statu==1){
            statuStr="可借阅";
        }
        else if(statu==0){
            statuStr="不可借阅";
        }
        return statuStr;
    }

    public void setStatuStr(String statuStr) {
        this.statuStr = statuStr;
    }

    public String getPublishTimeStr() {
        if(publishTime!=null){
            publishTimeStr= DateUtils.date2String(publishTime,"yyyy-MM-dd HH:mm:ss");
        }


        return publishTimeStr;
    }

    public void setPublishTimeStr(String publishTimeStr) {
        this.publishTimeStr = publishTimeStr;
    }

}
