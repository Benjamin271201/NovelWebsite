/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author ASUS GAMING
 */
public class Bookmark implements Serializable{
    private String username, novelID;

    public Bookmark() {
    }

    public Bookmark(String username, String novelID) {
        this.username = username;
        this.novelID = novelID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNovelID() {
        return novelID;
    }

    public void setNovelID(String novelID) {
        this.novelID = novelID;
    }
    
}
