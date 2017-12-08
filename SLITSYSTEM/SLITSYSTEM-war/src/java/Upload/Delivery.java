package Upload;

    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krish
 */
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Delivery implements Serializable{
    @Id
    @GeneratedValue 
    private int Delivery_ID;
    @Column
    private Blob file;
    @Column
    private String Comment;
    @Column
    private String Title;
    @Column 
    private Boolean approved;

    
    public Delivery(Blob file, String Comment, String Title, Boolean approved) {
 
        this.file = file;
        this.Comment = Comment;
        this.approved = approved;
        this.Title = Title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getDelivery_ID() {
        return Delivery_ID;
    }

    public void setDelivery_ID(int Delivery_ID) {
        this.Delivery_ID = Delivery_ID;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
}

    
