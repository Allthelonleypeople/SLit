package Login_and_Authorisation;


import Management.UserManagerLocal;
import users.Bruker;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

/**
 * @author Rasmus
 */
@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); 
        
        // Prøver å finne brukernavn i database
        //Måler brukernavn og string passord opp mot passord i database
        try {
            Bruker b = manager.getUser(email.toLowerCase());
        if (b.getPassword().equals(password)){
            //hvis brukernavn og passord er riktig starter den en ny session. 
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", b);
            
                //sjekker brukertype om det er admin, lærer eller student
                switch (b.getUserType()) {
                    case "admin":
                        response.sendRedirect("/SLITSYSTEM-war/AdminMenu");
                        break;
                    case "teacher":
                        response.sendRedirect("/SLITSYSTEM-war/TeacherMenu");
                        break;
                    default:
                        response.sendRedirect("/SLITSYSTEM-war/Hovedmeny.html");
                        break;
                }
        }        
        else{
                response.sendRedirect("/SLITSYSTEM-war/loginfeil.html");       
            }            
        }
        catch (NullPointerException nullp) {
            System.err.println("NullPointerException: " + nullp.getMessage());
            response.sendRedirect("/SLITSYSTEM-war/loginfeil.html");
    }
    }

    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        login(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        login(request, response);
    }
}

