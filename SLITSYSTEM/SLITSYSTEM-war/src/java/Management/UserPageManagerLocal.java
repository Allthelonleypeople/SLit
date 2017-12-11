package Management;

import UserPage.UserPage;
import javax.ejb.Local;

@Local
public interface UserPageManagerLocal {

    UserPage getDescription(String UserID);

    boolean saveUserPage(UserPage u);
}
