package Management;

//import Module.Module;
import Upload.Delivery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public boolean saveDelivery(Delivery d){
        Delivery existing = getDelivery(d.getDelivery_ID());
        if  (existing == null){
            em.persist(d);
        } else{
            return false;
        }
        return true;
    }

    /**
     *
     * @param d
     * @return
     */
    @Override
    public boolean updateDelivery(Delivery d){
        Delivery existing = getDelivery(d.getDelivery_ID());
        if  (existing == null){
            em.merge(d);
        } else{
            return false;
        }
        return true;
        }
    }
