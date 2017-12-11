package Management;

import Blog.Poster;
import javax.ejb.Local;

/**
 *
 * @author Stian
 */
@Local
public interface PostManagerLocal {
    Poster getInnhold(int id);
    Poster getInfo(String info);
    boolean savePost(Poster p);
}
