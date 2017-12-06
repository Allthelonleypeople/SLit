/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
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
    private String email;
    @Column
    private String ModuleOppgaveID;
    
    
    public Feedback() {}

    public Feedback(String comment, String rating, String email, String ModuleOppgaveID) {
        this.comment = comment;
        this.rating = rating;
        this.email = email;
        this.ModuleOppgaveID = ModuleOppgaveID;
        
    }

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

    public void getEmail(Bruker bruker) {
        bruker.getEmail();
    }

  
    public void getModuleOppgaveID(ModuleOppgave Module) {
        Module.getModuleOppgaveID();
    }

   
    
    
}
