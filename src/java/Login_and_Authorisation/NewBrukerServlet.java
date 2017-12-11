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
        import java.io.PrintWriter;


@WebServlet ("/NewBrukerServlet")


public class NewBrukerServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;
    // etode for å legge til en ny bruker. 
    private void newBruker (HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String userType = request.getParameter("userType"); 
        

        Bruker b = new Bruker(email.toLowerCase(), password, fName, lName, userType);
        if(manager.saveUser(b) == true){
            out.print("Din bruker har blitt opprettet!  ");
            out.print("Du vil nå bli videresendt til innloggingen   ");            
            response.sendRedirect("/SLITSYSTEM-war/index.html");
        } else if (manager.saveUser(b) == false){
            out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
        }
        
      

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newBruker(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newBruker(request, response);
    }
}
