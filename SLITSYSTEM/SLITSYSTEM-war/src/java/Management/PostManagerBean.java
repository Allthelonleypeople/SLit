package Management;

import Blog.Poster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PostManagerBean implements PostManagerLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    public PostManagerBean() {        
    }
    
    @Override
    public Poster getInnhold(int id) {
        return em.find(Poster.class, id);
    }
    
    @Override
    public Poster getInfo(String info) {
        return em.find(Poster.class, info);
    }
    
    @Override
    public boolean savePost(Poster p) {
        Poster existing = getInnhold(p.getPostID());
        if (existing == null) {
            em.persist(p);
        } else {
            return false;
        }
        return true;
    }
}
