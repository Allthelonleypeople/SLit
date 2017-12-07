/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;


//import Feedback.FeedbackManagerLocal;
//import Tilbakemelding.Feedback;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FeedbackManagerBean implements FeedbackManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public FeedbackManagerBean(){
    }

    @Override
    public Feedback getFeedback(int id) {
        return em.find(Feedback.class, id);
    }

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
       @Override
    public Feedback getFeedback(String comment) {
        return em.find(Feedback.class, comment);
    }
}

