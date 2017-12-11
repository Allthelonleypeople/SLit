<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Opplasting</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Opplasting</h2>
            </div>
            <div class ="column header right"> 
                <h2>Bruker</h2>
            </div>

            <div class ="venstre">
                <u1>
                    <li><a href="Hovedmeny.jsp">Hovedside</a></li>
                    <li><a href="Moduler.jsp">Moduler</a></li>
                    <li><a href="Forum">Forum</a></li>
                    <li><a href="Blog.jsp">Blogg</a></li>                
                </u1>
            </div>

            <div class="midt">
                <form method="post" action="uploadServlet" enctype="multipart/form-data">
                    <table border="0">

                        <td>Title: </td>
                        <td><input type="text" name="Title" size="50"/></td>
                        <br><br>

                        <td>Comment: </td>
                        <td><input type="text" name="comment" size="50"/></td>


                        <tr>
                            <td>Innlevering: </td>
                            <td><input type="file" accept=" .doc, .txt, .jar, .docx" name="file" size="50"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Save">
                            </td>
                            
        <p>${errorMessage}</p>
        <c:remove var="errorMessage" scope="session"/>
                  <p>${oppdatert}</p>
       
                    
                    <td colspan="2">
                        <input type="submit" value="Save"> <br><br>
                        
                          <c:remove var="oppdatert" scope="session"/>
                  <p>${godStemning}</p>
        <c:remove var="godStemning" scope="session"/>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>


