/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author chiuy
 */
public class Comment {
    private String commentID;
    private Chapter chapter;
    private Account user;
    private String context;
    private Date commentDate;

    public Comment(){}

    public Comment(String commentID, Chapter chapter, Account user, String context, Date commentDate) {
        this.commentID = commentID;
        this.chapter = chapter;
        this.user = user;
        this.context = context;
        this.commentDate = commentDate;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
    
}
