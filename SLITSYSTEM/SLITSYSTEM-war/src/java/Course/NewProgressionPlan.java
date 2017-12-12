/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Management.PlanManagerLocal;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import users.Bruker;


/**
 *
 * @author RasmusRS
 */
public class NewProgressionPlan extends HttpServlet {
    
    @EJB
    PlanManagerLocal manager;
private void newProgressionPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String courseName = request.getParameter("courseName");
        String numbOfModules = request.getParameter("numbOfModules"); 
        String planningInfo = request.getParameter("planningInfo"); 
        
        HttpSession session = request.getSession();
        Bruker loginUser = (Bruker) session.getAttribute("loginUser");
        String currentUserEmail = loginUser.getEmail();

        Plan p = new Plan(courseName, numbOfModules, planningInfo);
        if (manager.savePlan(p) == true) {
            out.print("Din progresjonsplan har blitt lagret!");
            out.print("Du vil nå bli sendt tilbake til forsiden");
            response.sendRedirect("Progressionplan.jsp");
        } else if (manager.savePlan(p) == false) {
            out.print("Planen ble ikke lagret, vennligst prøv igjen");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newProgressionPlan(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newProgressionPlan(request, response);
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
}