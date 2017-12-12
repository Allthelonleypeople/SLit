package Upload;

    
/*
 * Creates a delivery object and a MySQL table to store it in.
 * 
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

/**
 * 
 * @return 
 */
    public String getTitle() {
        return title;
    }
/**
 * 
 * @param title 
 */
    public void setTitle(String title) {
        this.title = title;
    }
/**
 * 
 * @return 
 */
    public int getDelivery_ID() {
        return Delivery_ID;
    }
/**
 * 
 * @param Delivery_ID 
 */
    public void setDelivery_ID(int Delivery_ID) {
        this.Delivery_ID = Delivery_ID;
    }
/**
 * 
 * @return 
 */
    public byte[] getContents() {
        return contents;
    }
/**
 * 
 * @param contents 
 */
    public void setContents(byte[] contents) {
        this.contents = contents;
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

    
