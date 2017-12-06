<%--
  User: Sindre
  Date: 14/11/2017
  Time: 15.00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slit</title>
</head>
    <body>
<form method="post" action="/SLITSYSTEM-war/FeedbackServlet">

    
  Modulnummer  <input type="number" name="ModuleOppgaveID" value="Velg modulnummer"><br>
  Studentens email  <input type="text" name="email"><br>
  Kommentar <input type="text" name="comment" ><br>
  Poengsum  <input type="number" name="rating" value="Skriv inn score - range 1-10" min="1" max="10"><br><br>
    <input type="submit" value="Lagre">
</form>


</body>
</html>