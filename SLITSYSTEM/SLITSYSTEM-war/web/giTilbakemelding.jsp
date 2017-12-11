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
   <form method="post" action="/SLITSYSTEM-war/newFeedback"   accept-charset="UTF-8">
       
        
       Legg til kommentar til modulen:<br>
       <textarea  name="comment"></textarea><br><br>
       Poengsum:  <input type="text" name="rating"><br><br>
       
       <input type="submit" value="Publiser kommentar" /><br><br>
       <input type="reset" value="Reset" />
   </form>
        
        



</body>
</html>