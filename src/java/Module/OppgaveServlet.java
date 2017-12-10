
package Module;

        
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.text.ParseException;


@WebServlet(name = "newOppgaveServlet", urlPatterns = {"/newOppgaveServlet"})
public class OppgaveServlet extends HttpServlet {

    

    private void newOppgaveServlet (HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        if (null == request.getParameter("ModuleOppgave")) {
            String errorMessage = "Velg modul i lista!";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("NewModule.jsp");
            
        } else switch (request.getParameter("ModuleOppgave")) {
            case "1":
                {
                    int ModuleOppgaveID = 1;
                    getParameters(ModuleOppgaveID, request, response);
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
    private void getParameters(int ModuleOppgaveID, HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String task = request.getParameter( "task");
        String criterias = request.getParameter("criterias");
        String deadline = request.getParameter("deadline");
        
        

     

            ModuleOppgave m = new ModuleOppgave(ModuleOppgaveID, task, criterias, deadline);
            try {

                saveToDB(m, response);
            } catch (IOException | ServletException e) {
            }


        }
    

    @EJB
    private
    ModuleManagerLocal manager;

    /**
     * @param m
     * @param response
     * @throws ServletException
     * @throws IOException      Lagrer modulen i databasen
     */

    private void saveToDB(ModuleOppgave m, HttpServletResponse response) throws ServletException, IOException {
        if (manager.updateModuleOppgave(m)) {
            response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
        } else {
            if (manager.saveModuleOppgave(m)) {
                response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
            } else {
                response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
            }
        }
    }

    /**
     * Standard Java metode for HTTP GET
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            newOppgaveServlet(request, response);
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
            newOppgaveServlet(request, response);
        } catch (ParseException e) {
        }
    }
}
