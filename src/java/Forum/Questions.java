package Forum;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questions implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int QuestionID;
    @Column
    private String loginUser;
    @Column
    private String kategori;
    @Column
    private String QuestionText;

    public Questions(String loginUser, String kategori, String QuestionText) {
        this.loginUser = loginUser;
        this.kategori = kategori;
        this.QuestionText = QuestionText;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String QuestionText) {
        this.QuestionText = QuestionText;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    protected Questions() {
    }

}
