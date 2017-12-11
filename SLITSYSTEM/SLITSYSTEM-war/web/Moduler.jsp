<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Hovedmeny</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css"/>
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Moduler</h2>
            </div>
            <div class ="column header right"> 
                <h2>Bruker</h2>
            </div>

            <div class ="venstre">                  
                <u1>
                    <li><a href="Hovedmeny.jsp">Hovedside</a></li>
                    <li><a class="active" href="Moduler.jsp">Moduler</a></li>
                    <li><a href="Forum">Forum</a></li>
                    <li><a href="Blog.jsp">Blogg</a></li>                
                </u1>
            </div>

            <div class="midt">  
                <form action="ModuleListe.jsp">
                    <button class="button"><span>Se moduler </span></button>
                </form>
                <br><br><br>
                <form action="Innlevering.jsp">
                    <button class="button"><span>Lever modul </span></button>
                </form>
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>
