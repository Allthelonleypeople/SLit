package Module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sindrethompson
 * 
 * Det er en EJB med metoder som behandler modulobjekter
 * 
 */
@Stateless
public class ModuleManagerBean implements ModuleManagerLocal {

    @PersistenceContext
    private EntityManager em;
    

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ModuleOppgave getModuleOppgave(int id) {
        return em.find(ModuleOppgave.class, id);
    }

    /**
     *
     * @param m
     * @return
     */
    @Override
    public boolean saveModuleOppgave(ModuleOppgave m){
        ModuleOppgave existing = getModuleOppgave(m.getModuleOppgaveID());
        if  (existing == null){
            em.persist(m);
        } else{
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param m
     * @return
     */
    @Override
    public boolean updateModuleOppgave(ModuleOppgave m){
        ModuleOppgave existing = getModuleOppgave(m.getModuleOppgaveID());
        if (existing != null) {
            em.merge(m);
            em.flush();
        } else {
            return false;
    }
    return true;
}
}
    
  