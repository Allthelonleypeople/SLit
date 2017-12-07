
package Tilbakemelding;


import Tilbakemelding.Feedback;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface FeedbackManagerLocal {
    Feedback getFeedback(int id);
    boolean saveFeedback(Feedback f);
    boolean updateFeedback(Feedback f);
 
   
}
