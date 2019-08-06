package Forum;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comments implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int CommentID;
    @Column
    private String QuestionComment;
    @Column
    private String QuestionID;
    @Column
    private String loginUser;

    public Comments(String QuestionComment, String QuestionID, String loginUser) {
        this.QuestionComment = QuestionComment;
        this.QuestionID = QuestionID;
        this.loginUser = loginUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    

    public String getQuestionComment() {
        return QuestionComment;
    }

    public void setQuestionComment(String QuestionComment) {
        this.QuestionComment = QuestionComment;
    }
    
    public int getCommentID(){
        return CommentID;
    }
    
    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }
    
    
    public  String QuestionID(){
        return QuestionID;
    }
    
    public void setQuestionID(String QuestionID) {
        this.QuestionID = QuestionID;
    }

    protected Comments() {
    }

}
