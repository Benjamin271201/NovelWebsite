/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author chiuy
 */
public class Novel {
    private String novelID;
    private ArrayList<Tag> tags;
    private String novelName;
    private int viewCount;
    private Account author;
    private Date uploadDate;

    public Novel(){}
    
    public Novel(String novelID, ArrayList<Tag> tags, String novelName, int viewCount, Account author, Date uploadDate) {
        this.novelID = novelID;
        this.tags = tags;
        this.novelName = novelName;
        this.viewCount = viewCount;
        this.author = author;
        this.uploadDate = uploadDate;
    }

    public String getNovelID() {
        return novelID;
    }

    public void setNovelID(String novelID) {
        this.novelID = novelID;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    
    
}
