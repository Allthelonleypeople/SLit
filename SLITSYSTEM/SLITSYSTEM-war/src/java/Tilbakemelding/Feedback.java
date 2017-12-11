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

/**
 *
 * @author sindrethompson
 * Klasse med felt for feedback til moduler
 * 
 */
@Entity
public class Feedback implements Serializable {
    
    @Id
    @GeneratedValue
    private int FeedbackId;
    @Column
    private String comment;
    @Column
    private int rating;
    @Column
    private String loginUser;
    
    /**
     *
     * @param loginUser
     * @param comment
     * @param rating
     */
    public Feedback(String loginUser, String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
        this.loginUser = loginUser;
      
    }
    
    /**
     * Meningen at denne constructoren skal være tom
     */
    public Feedback() {}

    /**
     *
     * @return
     */
    public int getFeedbackId() {
        return FeedbackId;
    }

    /**
     *
     * @param FeedbackId
     */
    public void setFeedbackId(int FeedbackId) {
        this.FeedbackId = FeedbackId;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public String getLoginUser() {
        return loginUser;
    }

    /**
     *
     * @param loginUser
     */
    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    
    


   
    
    
}
