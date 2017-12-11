package Upload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import Management.DeliveryManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import users.Bruker;


/**
 * @author Sindre Thompson
 * 
 * Servlet som laster skal laste opp en fil til databasen
 * 
 */

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})

public class UploadServlet extends HttpServlet {
   
  
    /**
     * Kommunikasjon med databasen
     */

     @EJB
    DeliveryManagerLocal manager;
     
     /**
      * Enkel fil-til-byteArray metode
      * Konverterer filen til byte arrays
      * @return
      * @throws IOException 
      */
    
        private byte[] convertToByteArray() throws IOException {
      
        ByteArrayOutputStream fileOutPutStream = new ByteArrayOutputStream();

      

        return fileOutPutStream.toByteArray();
    }
        
        /**
         * 
         * Uploader byteArrayet til databasen
         * Blir lagret som en BLOB i sql
         *
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         * @throws ParseException 
         */
     
    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Bruker loginUser =  (Bruker) session.getAttribute("loginUser");
        

                        String comment = request.getParameter("comment");
                        byte[] contents = convertToByteArray();
                        String title = request.getParameter("title");
                        String currentUserEmail = loginUser.getEmail();
                          
                        Delivery delivery = new Delivery(comment, contents, title, currentUserEmail);
                      
        
                        if (manager.updateDelivery(delivery, request, response)) {
                            out.print("Leveringen ble oppdatert");
                            String oppdatert = "Leveringen ble oppdatert";
                            request.getSession().setAttribute("oppdatert", oppdatert);
                            response.sendRedirect("Uploaded.jsp");
                        } else {
                            out.print("Leveringen ble ikke oppdatert");
                            if (manager.saveDelivery(delivery)) { 
                                out.print("Filen ble lagret");
                                String godStemning = "Filen ble levert";
                                request.getSession().setAttribute("godStemning", godStemning);
                                response.sendRedirect("Uploaded.jsp");
                            } else {
                                out.print("Error");
                                String errorMessage = "Velg modul i lista!";
                                request.getSession().setAttribute("errorMessage", errorMessage); //Skriver ut melding på JSP hvis du ikke har valgt
                                response.sendRedirect("Uploaded.jsp");    
                            }
                        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
             upload(request,response);
         } catch (ParseException ex) {
             Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }   
    
    
    
