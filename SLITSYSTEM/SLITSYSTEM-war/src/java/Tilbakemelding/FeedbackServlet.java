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
        import java.text.ParseException;
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

  
         private void getParameters(int FeedbackId, HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
     
        
     
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");
        
        HttpSession session = request.getSession();
        Bruker loginUser =  (Bruker) session.getAttribute("loginUser");
        
        String currentUserEmail = loginUser.getEmail();
        
        

     Feedback f = new Feedback(currentUserEmail, FeedbackId, comment, rating);

               try {
            feedbackTilDatabase(f, request, response); 
        } catch (IOException | ServletException ioe) {
            ioe.printStackTrace();
        }
    


      }
    
    private void newFeedback (HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

      

        if (null == request.getParameter("Feedback")) {
            String errorM = "Velg modul i lista!";
            request.getSession().setAttribute("errorM", errorM);
            response.sendRedirect("NewModule.jsp");
            
        } else switch (request.getParameter("Feedback")) {
            case "1":
                {
                    int FeedbackId = 1;
                    getParameters(FeedbackId, request, response);
                    break;
                }
            case "2":
                {
                    int ModuleOppgaveID = 2;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "3":
                {
                    int ModuleOppgaveID = 3;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "4":
                {
                    int ModuleOppgaveID = 4;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "5":
                {
                    int ModuleOppgaveID = 5;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "6":
                {
                    int ModuleOppgaveID = 6;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "7":
                {
                    int ModuleOppgaveID = 7;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "8":
                {
                    int ModuleOppgaveID = 8;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "9":
                {
                    int ModuleOppgaveID = 9;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            case "10":
                {
                    int ModuleOppgaveID = 10;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
            default:
                break;
        }
    }

    

    @EJB
    private
    FeedbackManagerLocal manager;

    /**
     * @param f
     * @param response
     * @throws ServletException
     * @throws IOException      Lagrer modulen i databasen
     */

    private void feedbackTilDatabase(Feedback f, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (manager.updateFeedback(f)) {
            request.getSession().setAttribute("comment", f.getComment());
            request.getSession().setAttribute("rating", f.getRating());
            response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
        } else {
            manager.saveFeedback(f);
            request.getSession().setAttribute("comment", f.getComment());
            request.getSession().setAttribute("rating", f.getRating());
            response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
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
        try {
            newFeedback(request, response);
        } catch (ParseException e) {
        }
    }

    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            newFeedback(request, response);
        } catch (ParseException e) {
        }
    }
}
