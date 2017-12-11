/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;


        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import javax.servlet.http.HttpSession;
        import users.Bruker;

/**
 *
 * @author sindrethompson
 * 
 * Servlet for å teacher som skal skrive feedback
 * til studenter som har levert moduler.
 * 
 */
@WebServlet(name = "newFeedback", urlPatterns = {"/newFeedback"})


public class FeedbackServlet extends HttpServlet {

  
          @EJB
    FeedbackManagerLocal manager;

    private void newFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");
        
        
        HttpSession session = request.getSession();
        Bruker loginUser = (Bruker) session.getAttribute("loginUser");
        String currentUserEmail = loginUser.getEmail();

        Feedback f = new Feedback(currentUserEmail, comment, rating);
        if (manager.saveFeedback(f) == true) {
            out.print("Din post har blitt lagret!");
            out.print("Du vil nå bli sendt tilbake til bloggen");
            response.sendRedirect("ModuleListe.jsp");
        } else if (manager.saveFeedback(f) == false) {
            out.print("Feedbacken ble ikke lagret, prøv igjen..");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newFeedback(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newFeedback(request, response);
    }
}

