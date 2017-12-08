
package Management;

import Upload.Delivery;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface DeliveryManagerLocal {

    /**
     *
     * @param id
     * @return
     */
    Delivery getDelivery(int id);
    boolean saveDelivery(Delivery d);
    boolean updateDelivery(Delivery d);
}
