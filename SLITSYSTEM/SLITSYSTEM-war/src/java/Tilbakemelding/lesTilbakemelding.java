/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tilbakemelding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import users.Bruker;

/**
 *
 * @author sindrethompson
 */
@WebServlet(name = "lesTilbakemelding", urlPatterns = {"/lesTilbakemelding"})
public class lesTilbakemelding extends HttpServlet {

    @EJB
    private FeedbackManagerLocal fbml;
    
        private void checkButtonValue(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("Module") != null) {
            int knappTrykketInt = 1;
            getFromDB(knappTrykketInt, request, response);

        } else if (request.getParameter("module2") != null) {
            int knappTrykketInt = 2;
            getFromDB(knappTrykketInt, request, response);

    }
        }
    private void getFromDB(int knappTrykketInt, HttpServletRequest req, HttpServletResponse res) throws IOException {

        String knappTrykketString = Integer.toString(knappTrykketInt);

        HttpSession session = req.getSession();
        Bruker loggedInUser = (Bruker) session.getAttribute("loggedInUser");
        String currentUser = loggedInUser.getEmail();

        String primaryChunk = currentUser + knappTrykketString + "fb";

        Feedback fb = fbml.getFeedback(primaryChunk);
        if (fb == null) {
            writeNullToJSP(req, res, knappTrykketString);
        } else {
            String feedbackcontent = fb.getComment();
            String rating = fb.getRating();
           

            try {
                writeToJSP(req, res, knappTrykketString, feedbackcontent, rating);
            } catch (ServletException | IOException se) {
                se.printStackTrace();
            }
        }
    }

    private void writeToJSP(HttpServletRequest req, HttpServletResponse res, String knappTrykketString, String comment, String rating) throws ServletException, IOException {
        req.getSession().setAttribute("error", null);
        req.getSession().setAttribute("ModuleOppgaveID", knappTrykketString);
        req.getSession().setAttribute("comment", comment);
        req.getSession().setAttribute("rating", rating);
        res.sendRedirect("lesTilbakemeldinger.jsp");
    }
    private void writeNullToJSP(HttpServletRequest req, HttpServletResponse res, String knappTrykketString) throws IOException {
        String error = "Det skjedde en feil :(<BR>Vi fant dessverre ingenting i databasen.<BR>Tips: Spør læreren om han/hun har lagt ut feedback til din modul nr. " + knappTrykketString + ".";
        req.getSession().setAttribute("error", error);
        req.getSession().setAttribute("modulnr", null);
        req.getSession().setAttribute("feedbackContent", null);
        req.getSession().setAttribute("score", null);
        req.getSession().setAttribute("timewritten", null);
        res.sendRedirect("lesTilbakemeldinger.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }
}