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

    /**
     * 
     * @param request
     * @param response
     * @throws IOException 
     */
    private void newFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Henter ut parameterene som blir skreve i JSP-en 
        //når programmet kjører
        
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");
        int ratingINT = Integer.parseInt(rating);
        
        //Henter ut emailen til læreren som skriver tilbakemeldingen   
        HttpSession session = request.getSession();
        Bruker loginUser = (Bruker) session.getAttribute("loginUser");
        String currentUserEmail = loginUser.getEmail();

        //Sender parameterne til databasen
        Feedback f = new Feedback(currentUserEmail, comment, ratingINT);
        if (manager.saveFeedback(f) == true) {
            out.print("Din post har blitt lagret!");
            out.print("Du vil nå bli sendt tilbake til bloggen");
            response.sendRedirect("ModuleListe.jsp");
        } else if (manager.saveFeedback(f) == false) {
            out.print("Feedbacken ble ikke lagret, prøv igjen..");
            String errorM = "Feedbacken ble ikke lagret, prøv igjen";
            request.getSession().setAttribute("errorM", errorM);
            response.sendRedirect("NewModule.jsp");
            
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newFeedback(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newFeedback(request, response);
    }
}

