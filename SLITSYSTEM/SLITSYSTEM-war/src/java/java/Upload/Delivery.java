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
//import javax.persistence.*;
import java.io.Serializable;
//import java.sql.Blob;
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
    private String comment;
    @Column
    private byte[] contents;
    @Column
    private String title;
    @Column
    private String loginUser;
 

    
    public Delivery(String comment, byte[] contents, String title, String loginUser) {
  
        this.contents = contents;
        this.comment = comment;
        this.title = title;
        this.loginUser = loginUser;
    }
    
    public Delivery(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDelivery_ID() {
        return Delivery_ID;
    }

    public void setDelivery_ID(int Delivery_ID) {
        this.Delivery_ID = Delivery_ID;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    
    

    
}

    
