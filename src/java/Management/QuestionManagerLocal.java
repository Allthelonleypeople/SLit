package Management;

import Forum.Questions;
import javax.ejb.Local;

/**
 *
 * @author Stian
 */
@Local
public interface QuestionManagerLocal {

    Questions getQuestionText(int id);

    boolean saveQuestion(Questions q);
}
