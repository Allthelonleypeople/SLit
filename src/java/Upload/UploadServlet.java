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
import users.Bruker;


/**
 * @author Sindre Thompson
 */

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})

public class UploadServlet extends HttpServlet {
   
  

     @EJB
    DeliveryManagerLocal manager;
    
        private byte[] convertToByteArray() throws IOException {
      
        ByteArrayOutputStream fileOutPutStream = new ByteArrayOutputStream();

      

        return fileOutPutStream.toByteArray();
    }
     
    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        Bruker loginUser =  (Bruker) session.getAttribute("loginUser");
        

                        String comment = request.getParameter("comment");
                        byte[] contents = convertToByteArray();
                        String title = request.getParameter("title");
                        String currentUserEmail = loginUser.getEmail();
                          
                         Delivery delivery = new Delivery(comment, contents, title, currentUserEmail);
                      
        
                        if (manager.updateDelivery(delivery, request, response)) {
                        } else {
                            
                            if (manager.saveDelivery(delivery)) {
                            } else {
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
    
    
    
