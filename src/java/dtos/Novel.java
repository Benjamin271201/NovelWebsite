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
    private String novelName;
    private int viewCount;
    private Account author;
    private String coverURL;

    public Novel(){}

    public Novel(String novelID, String novelName, int viewCount, Account author, String coverURL) {
        this.novelID = novelID;
        this.novelName = novelName;
        this.viewCount = viewCount;
        this.author = author;
        this.coverURL = coverURL;
    }

    public String getNovelID() {
        return novelID;
    }

    public void setNovelID(String novelID) {
        this.novelID = novelID;
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

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }
    
    
}
