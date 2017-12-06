<%-- 
    Document   : skrivModuler
    Created on : 05.des.2017, 19:50:42
    Author     : sindrethompson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="Moduler" size="1">
            <option>Modul 1</option>
            <option>Modul 2</option>
            <option>Modul 3</option>
            <option>Modul 4</option>
            <option>Modul 5</option>
        </select>
           <p>${ModuleOppgave}</p>
   <c:remove var="ModuleOppgave" scope="session"/>    
        
    </body>
</html>
