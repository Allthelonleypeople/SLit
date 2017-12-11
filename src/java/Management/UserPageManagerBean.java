package Management;

import UserPage.UserPage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserPageManagerBean implements UserPageManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public UserPageManagerBean() {
    }

    @Override
    public UserPage getDescription(String id) {
        return em.find(UserPage.class, id);
    }

    @Override
    public boolean saveUserPage(UserPage u) {
        UserPage existing = getDescription(u.getUserID());
        if (existing == null) {
            em.persist(u);
        } else {
            return false;
        }
        return true;
    }
}
