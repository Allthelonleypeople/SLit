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


@WebServlet ("/FeedbackServlet")


public class FeedbackServlet extends HttpServlet {

    @EJB
    FeedbackManagerLocal manager;

    private void newFeedback (HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");
        String email = request.getParameter("email");
        String ModuleOppgaveID = request.getParameter("ModuleOppgaveID");
 
        
        
       
        

        Feedback f = new Feedback(comment, rating, email, ModuleOppgaveID);
        if(manager.saveFeedback(f) == true){
            out.print("Tilbakemelding opprettet ");
            response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
        } else if (manager.saveFeedback(f) == false){
            out.print("Feil, prøv igjen ");
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

