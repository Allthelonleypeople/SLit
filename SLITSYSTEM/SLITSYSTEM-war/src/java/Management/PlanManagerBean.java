package Management;

import Course.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlanManagerBean implements PlanManagerLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    public PlanManagerBean() {        
    }
    
    @Override
    public Plan getDescription(int id) {
        return em.find(Plan.class, id);
    }
    
    
    
    @Override
    public boolean savePlan(Plan p) {
        Plan existing = getDescription(p.getPlanID());
        if (existing == null) {
            em.persist(p);
        } else {
            return false;
        }
        return true;
    }
}
