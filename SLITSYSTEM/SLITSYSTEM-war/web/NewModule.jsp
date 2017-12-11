<%@ page import="users.Bruker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
  
    <main>     
        
     <form method="post" action="/SLITSYSTEM-war/newOppgaveServlet"  id="newM" accept-charset="UTF-8">
         <select name="ModuleOppgave">
             <option> -Velg modul-</option>
             <option  name="ModuleOppgave" value="1"> Modul 1</option>
             <option  name="ModuleOppgave" value="2"> Modul 2</option>
             <option  name="ModuleOppgave" value="3"> Modul 3</option><br>
             <option  name="ModuleOppgave" value="4"> Modul 4</option><br>
             <option  name="ModuleOppgave" value="5"> Modul 5</option><br>
             <option  name="ModuleOppgave" value="6"> Modul 6</option><br>
             <option  name="ModuleOppgave" value="7"> Modul 7</option><br>
             <option  name="ModuleOppgave" value="8"> Modul 8</option><br>
             <option  name="ModuleOppgave" value="9"> Modul 9</option><br>
             <option  name="ModuleOppgave" value="10"> Modul 10</option><br>
     
        </select>
        
        

        <p>${errorMessage}</p>
        <c:remove var="errorMessage" scope="session"/>
        
        
    </form>
          <div>
        Oppgave: <br>
        <textarea name="task" form="newM" placeholder="Skriv om opppgaven her"></textarea>
        <br>
        Kriterier: <br>
        <textarea name="criterias" form="newM" placeholder="Kriterier for godkjent"></textarea> <br>
        Deadline: <br>
        <textarea name="deadline" form="newM" placeholder="Deadline"></textarea> <br>
     
        
        <input type="submit" value="Last opp" form="newM" style="margin-bottom: 1cm">
        <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
    </div>
    </body>
</main>
        
</html>
