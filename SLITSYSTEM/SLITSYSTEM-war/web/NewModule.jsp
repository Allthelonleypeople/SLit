<%@ page import="users.Bruker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Bruker bruker = (Bruker) session.getAttribute("bruker");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ny modul</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Opprett modul</h2>
            </div>
            <div class ="column header right"> 
                <h2>Lærer</h2>
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
                <main>
                    <form method="post" action="/SLITSYSTEM-war/newOppgaveServlet"  id="newM" accept-charset="UTF-8">
                        <select name="ModuleOppgave">
                            <option value="1">Modul 1</option>
                            <option value="2">Modul 2</option>
                            <option value="3">Modul 3</option>
                            <option value="4">Modul 4</option>
                            <option value="5">Modul 5</option>
                            <option value="6">Modul 6</option>
                            <option value="7">Modul 7</option>
                            <option value="8">Modul 8</option>
                            <option value="9">Modul 9</option>
                            <option value="10">Modul 10</option>

                        </select>

                        <p>${errorMessage}</p>
                        <c:remove var="errorMessage" scope="session"/>
                    </form>
                    <div>
                        Oppgave: <br>
                        <textarea name="task" form="newM" placeholder="Skriv om opppgaven her"></textarea>
                        <br><br>
                        Kriterier: <br>
                        <textarea name="criterias" form="newM" placeholder="Kriterier for godkjent" rows="10" cols="25"></textarea> 
                        <br><br>
                        Deadline: <br>
                        <textarea name="deadline" form="newM" placeholder="Deadline" rows="10" cols="25"></textarea> 
                        <br><br>

                        <input type="submit" value="Last opp" form="newM" style="margin-bottom: 1cm">
                        <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
                    </div>
                </main>
            </div>                
            <div class="bottomheader"></div>
        </div>             
    </body>   
</html>
