package Management;

//import Module.Module;
import Upload.Delivery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krish
 */
@Stateless
public class DeliveryManagerBean implements DeliveryManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public DeliveryManagerBean(){
    }

    @Override
    public Delivery getDelivery(int id) {
        return em.find(Delivery.class, id);
    }

    @Override
    public boolean saveDelivery(Delivery delivery) {
        Delivery existing = getDelivery(delivery.getDelivery_ID());
        if (existing == null) {
            em.persist(delivery);
            em.flush();
        } else {
            return false;
        }
        return true;
    }
   

    @Override
    public boolean updateDelivery(Delivery delivery, HttpServletRequest request, HttpServletResponse response) throws NullPointerException {
        Delivery existing = getDelivery(delivery.getDelivery_ID());
            if (existing != null) {
                em.merge(delivery);
                em.flush();
            } else {
                return false;
            }
            return true;
    }
}
