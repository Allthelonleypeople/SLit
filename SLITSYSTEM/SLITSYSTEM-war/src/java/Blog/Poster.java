package Blog;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Poster implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int PostID;
    @Column
    private String tittel;
    @Column 
    private String innhold;
    @Column
    private String loginUser;

    public Poster(String tittel, String innhold, String loginUser) {
        this.tittel = tittel;
        this.innhold = innhold;
        this.loginUser = loginUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    
    

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getInnhold() {
        return innhold;
    }

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPosterID(int PostID) {
        this.PostID = PostID;
    }

    protected Poster() {
    }

}
