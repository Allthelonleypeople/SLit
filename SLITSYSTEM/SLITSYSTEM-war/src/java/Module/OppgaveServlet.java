package Module;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

/**
 *
 * @author sindrethompson
 */
@WebServlet(name = "newOppgaveServlet", urlPatterns = {"/newOppgaveServlet"})
public class OppgaveServlet extends HttpServlet {

    
    
    /**
     * Velger hvilken modul som skal opprettes, eller oppdateres 
     * Velger modul i en liste i JSP.
     * 
     * Switch og case er det samme som else if, men 
     * switch og case gir bedre oversikt
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ParseException 
     */
    private void newOppgaveServlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        if (null == request.getParameter("ModuleOppgave")) {
            String errorMessage = "Velg modul i lista!";
            request.getSession().setAttribute("errorMessage", errorMessage); //Skriver ut melding på JSP hvis du ikke har valgt
            response.sendRedirect("NewModule.jsp");                          //modulnummer
            

        } else {
            switch (request.getParameter("ModuleOppgave")) {
                case "1": {
                    int ModuleOppgaveID = 1;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "2": {
                    int ModuleOppgaveID = 2;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "3": {
                    int ModuleOppgaveID = 3;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "4": {
                    int ModuleOppgaveID = 4;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "5": {
                    int ModuleOppgaveID = 5;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "6": {
                    int ModuleOppgaveID = 6;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "7": {
                    int ModuleOppgaveID = 7;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "8": {
                    int ModuleOppgaveID = 8;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "9": {
                    int ModuleOppgaveID = 9;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                case "10": {
                    int ModuleOppgaveID = 10;
                    getParameters(ModuleOppgaveID, request, response);
                    break;
                }
                default:
                    break;
            }
        }

    }

    /**
     * Henter ut verdiene fra parameterne i newModule
     * 
     * @param ModuleOppgaveID
     * @param request
     * @param response
     * @throws ParseException
     * @throws IOException 
     */
    private void getParameters(int ModuleOppgaveID, HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String task = request.getParameter("task");
        String criterias = request.getParameter("criterias");
        String deadline = request.getParameter("deadline");

        ModuleOppgave m = new ModuleOppgave(ModuleOppgaveID, task, criterias, deadline);
        try {

            saveToDB(m, response);
        } catch (IOException | ServletException e) {
        }

    }

    @EJB
    private ModuleManagerLocal manager;

    /**
     * @param m
     * @param response
     * @throws ServletException
     * @throws IOException Lagrer modulen i databasen
     */
    private void saveToDB(ModuleOppgave m, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (manager.updateModuleOppgave(m)) {
            response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
            out.print("Velykket update"); //Skriver ut av oppdateringen av en allerede
                                          //eksisterende modul
        } else {
            if (manager.saveModuleOppgave(m)) {
                response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
                out.print("Modulen er lagret"); //Viser velykket operasjon av ny lagring.
            } else {
                response.sendRedirect("/SLITSYSTEM-war/ModuleListe.jsp");
                out.print("Ble ikke lagret eller oppdatert."); //Viser til at ikke noe ble oppdatert, eller lagret.
            }
        }
    }

    /**
     * Standard Java metode for HTTP GET
     *
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
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
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
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
