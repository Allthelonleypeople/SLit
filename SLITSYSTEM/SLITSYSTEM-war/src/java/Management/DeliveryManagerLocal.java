
package Management;

import Upload.Delivery;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * An interface which can be used for storing, 
 * updating and retriving data in a database.
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
    boolean saveDelivery(Delivery delivery);
    boolean updateDelivery(Delivery delivery, HttpServletRequest request, HttpServletResponse response);

    
}
