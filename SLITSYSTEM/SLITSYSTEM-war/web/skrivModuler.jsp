<%-- 
    Document   : skrivModuler
    Created on : 05.des.2017, 19:50:42
    Author     : sindrethompson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Skriv modul</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>  
            </div>
            <div class ="column header left"><h2>Skriv modul</h2></div>
            <div class ="column header right"><h2>Lærer</h2></div>      
            <div class="venstre">
                <u1>
                    <li><a href="Hovedmeny.jsp">Hovedside</a></li>
                    <li><a href="Moduler.jsp">Moduler</a></li>
                    <li><a href="Forum">Forum</a></li>
                    <li><a href="Blog.jsp">Blogg</a></li>                
                </u1>
            </div>
            <div class="midt">
                <select name="Moduler" size="1">
                    <option>Modul 1</option>
                    <option>Modul 2</option
                    <option>Modul 3</option>
                    <option>Modul 4</option>
                    <option>Modul 5</option>
                </select>
                <p>${ModuleOppgave}</p>
                <c:remove var="ModuleOppgave" scope="session"/>    
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>
