
package Tilbakemelding;


import Tilbakemelding.Feedback;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 * 
 * Interface-klasse for feedback. Alle metoder som er definert av inteface
 * må også implementeres i source-koden.
 */
@Local
public interface FeedbackManagerLocal {
    Feedback getFeedback(int id);
    boolean saveFeedback(Feedback f);
    boolean updateFeedback(Feedback f);
   
}
