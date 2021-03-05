/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author ASUS GAMING
 */
public class Chapter implements Comparable<Chapter>{
    private String chapterID;
    private String novelID;
    private String chapterName;
    private String fileURL;
    private String uploadDate;
    
    public Chapter() {
    }

    public Chapter(String chapterID, String novelID, String chapterName, String fileURL, String uploadDate) {
        this.chapterID = chapterID;
        this.novelID = novelID;
        this.chapterName = chapterName;
        this.fileURL = fileURL;
        this.uploadDate = uploadDate;
    }

    public String getChapterID() {
        return chapterID;
    }

    public void setChapterID(String chapterID) {
        this.chapterID = chapterID;
    }

    public String getNovelID() {
        return novelID;
    }

    public void setNovelID(String novelID) {
        this.novelID = novelID;
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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public int compareTo(Chapter o) {
        return uploadDate.compareTo(o.uploadDate);
    }
     
}
