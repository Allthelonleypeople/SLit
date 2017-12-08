/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sindrethompson
 * 
 * Det er en EJB med metoder som behandler feedback-objekter
 */
@Stateless
public class FeedbackManagerBean implements FeedbackManagerLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public FeedbackManagerBean(){
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Feedback getFeedback(int id) {
        return em.find(Feedback.class, id);
    }

    /**
     *
     * @param f
     * @return
     */
    @Override
    public boolean saveFeedback(Feedback f){
        Feedback existing = getFeedback(f.getFeedbackId());
        if  (existing == null){
            em.persist(f);
        } else{
            return false;
        }
        return true;
    }
   
    /**
     *
     * @param f
     * @return
     */
    @Override
    public boolean updateFeedback(Feedback f){
        Feedback existing = getFeedback(f.getFeedbackId());
        if (existing != null) {
            em.merge(f);
            em.flush();
        } else {
            return false;
    }
    return true;
}
}

