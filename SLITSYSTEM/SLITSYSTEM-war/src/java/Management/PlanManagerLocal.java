package Management;

import Course.Plan;
import javax.ejb.Local;

/**
 *
 * @author Stian
 */
@Local
public interface PlanManagerLocal {
    Plan getDescription(int id);
    boolean savePlan(Plan p);

}
