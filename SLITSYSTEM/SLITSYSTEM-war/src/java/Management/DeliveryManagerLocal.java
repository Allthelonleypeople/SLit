
package Management;

import Upload.Delivery;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    boolean saveDelivery(Delivery delivery);
    boolean updateDelivery(Delivery delivery, HttpServletRequest request, HttpServletResponse response);

    
}
