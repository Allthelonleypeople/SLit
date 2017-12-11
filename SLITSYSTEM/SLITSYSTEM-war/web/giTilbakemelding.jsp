<%--
  User: Sindre
  Date: 14/11/2017
  Time: 15.00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tilbakemelding</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Tilbakemelding</h2>
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
                <form method="post" action="/SLITSYSTEM-war/newFeedback"  id="newM" accept-charset="UTF-8">  

                    <select name="Feedback">
                        <option name="Feedback" value="1"> Modul 1</option>
                        <option name="Feedback" value="2"> Modul 2</option>
                        <option name="Feedback" value="3"> Modul 3</option>
                        <option name="Feedback" value="4"> Modul 4</option>
                        <option name="Feedback" value="5"> Modul 5</option>
                        <option name="Feedback" value="6"> Modul 6</option>
                        <option name="Feedback" value="7"> Modul 7</option>
                        <option name="Feedback" value="8"> Modul 8</option>
                        <option name="Feedback" value="9"> Modul 9</option>
                        <option name="Feedback" value="10"> Modul 10</option>
                    </select>

                    <p>${errorMessage}</p>
                    <c:remove var="errorMessage" scope="session"/>

                </form>
                <div>
                    Kommentar: <br>
                    <textarea name="comment" form="newM" placeholder="Skriv om opppgaven her"></textarea>
                    <br>
                    Poengsum: <br>
                    <textarea name="rating" form="newM" placeholder="Poengsum"></textarea> <br>

                    <input type="submit" value="Post tilbakemelding" form="newM" style="margin-bottom: 1cm">
                    <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
                </div>
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>