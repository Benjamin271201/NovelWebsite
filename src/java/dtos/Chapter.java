/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author ASUS GAMING
 */
public class Chapter implements Comparable<Chapter>{
    private String chapterID;
    private Novel novel;
    private String chapterName;
    private String fileURL;
    private Date uploadDate;

    public String getChapterID() {
        return chapterID;
    }

    public void setChapterID(String chapterID) {
        this.chapterID = chapterID;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Chapter(String chapterID, Novel novel, String chapterName, String fileURL, Date uploadDate) {
        this.chapterID = chapterID;
        this.novel = novel;
        this.chapterName = chapterName;
        this.fileURL = fileURL;
        this.uploadDate = uploadDate;
    }
    
    public Chapter() {
    }

    @Override
    public int compareTo(Chapter t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
