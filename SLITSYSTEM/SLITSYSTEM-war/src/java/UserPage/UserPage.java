package UserPage;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class UserPage implements Serializable {

    @Id
    @Column
    private String UserID;
    @Column
    private String Description;
        
    
    public UserPage(String UserID, String Description) {
        this.UserID = UserID;
        this.Description = Description;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    protected UserPage() {
    }
}
