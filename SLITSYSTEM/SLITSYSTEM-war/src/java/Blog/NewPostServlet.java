package Blog;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Management.PostManagerLocal;
import javax.servlet.http.HttpSession;
import users.Bruker;

@WebServlet(name = "NewPostServlet", urlPatterns = {"/NewPostServlet"})
public class NewPostServlet extends HttpServlet {

    @EJB
    PostManagerLocal manager;

    private void newPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String tittel = request.getParameter("tittel");
        String innhold = request.getParameter("innhold");
        
        HttpSession session = request.getSession();
        Bruker loginUser = (Bruker) session.getAttribute("loginUser");
        String currentUserEmail = loginUser.getEmail();

        Poster p = new Poster(currentUserEmail, tittel, innhold);
        if (manager.savePost(p) == true) {
            out.print("Din post har blitt lagret!");
            out.print("Du vil nå bli sendt tilbake til bloggen");
            response.sendRedirect("Blog.jsp");
        } else if (manager.savePost(p) == false) {
            out.print("Posten ble ikke algret, prøv igjen..");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newPost(request, response);
    }
}
