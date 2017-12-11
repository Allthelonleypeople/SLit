package UserPage;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Management.UserPageManagerLocal;

@WebServlet(name = "NewUserPageServlet", urlPatterns = {"/NewUserPageServlet"})
public class NewUserPageServlet extends HttpServlet {

    @EJB
    UserPageManagerLocal manager;
    
private void newUserPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String UserID = request.getParameter("UserID");
        String Description = request.getParameter("Description");

        UserPage u = new UserPage(UserID, Description);
        if (manager.saveUserPage(u) == true) {
            out.print("Brukersiden ble opprettet.");
            response.sendRedirect("/SLITSYSTEM-war/Hovedmeny.html");
        } else if (manager.saveUserPage(u) == false) {
            out.print("En feil oppstod.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newUserPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newUserPage(request, response);
    }
}
