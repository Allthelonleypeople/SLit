package Upload;

        import Management.DeliveryManagerLocal;
        import java.io.ByteArrayOutputStream;
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.PrintWriter;
import java.sql.Blob;
        import javax.servlet.http.Part;


@WebServlet ("/UploadServlet")
public class UploadServlet extends HttpServlet {

    @EJB
    DeliveryManagerLocal manager;

    private void newUploadServlet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  {

        request.setCharacterEncoding("UTF-8");
         PrintWriter out = response.getWriter();
        // gets values of text fields
         String Comment = request.getParameter("Comment");
         String Title = request.getParameter("Title");
         boolean approved = false;
         InputStream is = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            is =  filePart.getInputStream();
     
            try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
    {
        byte[] buffer = new byte[1024];

        for (int len; (len = is.read(buffer)) != -1;)
            os.write(buffer, 0, len);
         contents = os.toByteArray();
        
    }
             }
       
        
        Delivery d = new Delivery(contents, Comment, Title, approved);
        if(manager.saveDelivery(d) == true){
            out.print("Din fil har nå blitt opplastet!  ");
            out.print("Du vil nå bli videresendt tilbake til Hovedsiden   ");
            response.sendRedirect("/EnterpriseApplication1-war/MenuStudent");
        } else if (manager.saveDelivery(d) == false){
       out.print("Din fil kunne ikke bli opplastet, vennligst skjekk at filtype og størrelse er innenfor rammeverket og prøv igjen ");
        }
        
      

    }
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newUploadServlet(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newUploadServlet(request, response);
    }
}