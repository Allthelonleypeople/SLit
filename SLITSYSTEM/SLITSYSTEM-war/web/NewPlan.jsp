<%-- 
    Document   : NewPlan
    Created on : 12.des.2017, 10:55:41
    Author     : RasmusRS
--%>

<%@ page import="users.Bruker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Bruker bruker = (Bruker) session.getAttribute("bruker");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ny progresjonsplan</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Opprett progresjonsplan</h2>
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
                    <li><a href="Progressionplan.jsp">Progresjonsplan</a></li>
                </u1>
            </div>

            <div class="midt">  
                <main>
                    <form method="post" action="/SLITSYSTEM-war/NewProgressionPlan"  id="NewProgressionPlan" accept-charset="UTF-8">
                        KursNavn: <br>
                        <select name="courseName">
                            <option value="">-kursnavn-</option>
                            <option value="109">IS-109</option>
                            <option value="110">IS-110</option>
                        </select>
                    
                    <div>                        
                        Planlagt frist: <br>
                        <textarea name="numbOfModules" form="NewProgressionPlan" placeholder="Dine planlagte frister" rows="10" cols="25"></textarea> 
                        <br><br>
                        Planlegging: <br>
                        <textarea name="planningInfo" form="NewProgressionPlan" placeholder="" rows="10" cols="25"></textarea> 
                        <br><br>
                        <input type="submit" value="Last opp" form="NewProgressionPlan" style="margin-bottom: 1cm">
                        </form>
                        <input type="reset" value="Reset" form="NewProgressionPlan" style="margin-bottom: 1cm">
                    </div>
                </main>
            </div>                
            <div class="bottomheader"></div>
        </div>             
    </body>   
</html>