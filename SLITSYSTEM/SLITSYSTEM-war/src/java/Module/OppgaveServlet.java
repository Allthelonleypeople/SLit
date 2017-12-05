
package Module;

        
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;


@WebServlet ("/OppgaveServlet")
public class OppgaveServlet extends HttpServlet {

    @EJB
    ModuleManagerLocal manager;

    private void newOppgaveServlet (HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String task = request.getParameter("task");
        String criterias = request.getParameter("criterias");
        String deadline = request.getParameter("deadline");
        

        ModuleOppgave m = new ModuleOppgave(task, criterias, deadline);
        if(manager.saveModuleOppgave(m) == true){
            out.print("Din bruker har blitt opprettet!  ");
            out.print("Du vil nå bli videresendt til innloggingen   ");
            response.sendRedirect("/EnterpriseApplication1-war/gElev");
        } else if (manager.saveModuleOppgave(m) == false){
            out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
        }
        
      

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newOppgaveServlet(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newOppgaveServlet(request, response);
    }
}