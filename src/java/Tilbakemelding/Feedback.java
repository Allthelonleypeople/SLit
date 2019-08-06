/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import users.Bruker;
import Module.ModuleOppgave;

/**
 *
 * @author sindrethompson
 */

@Entity
public class Feedback implements Serializable {
    
    @Id
    @GeneratedValue
    private int FeedbackId;
    @Column
    private String comment;
    @Column
    private String rating;
    @Column
    private String loginUser;
    

    
    
   

    public Feedback(String loginUser, String comment, String rating) {
        this.comment = comment;
        this.rating = rating;
        //this.FeedbackId = FeedbackId;
        this.loginUser = loginUser;
      
    }
    
    public Feedback() {}



   

    

  

    public int getFeedbackId() {
        return FeedbackId;
    }

    public void setFeedbackId(int FeedbackId) {
        this.FeedbackId = FeedbackId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    
    


   
    
    
}
