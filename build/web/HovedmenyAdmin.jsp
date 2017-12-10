<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Hovedmeny</title> 
        <link rel="stylesheet" href="css.css">
        <meta charset="UTF-8">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="HovedmenyAdmin.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Hovedmeny</h2>
            </div>
            <div class ="column header right"> 
                <h2>Admin</h2>
            </div>
        </div>

        <div class ="venstre">
        </div>

        <div class="midt">
            <form action="">
                <button class="button"><span>Se moduler </span></button>
            </form>

            <form action="NewModule.jsp">
                <button class="button"><span>Opprett modul </span></button>
            </form>
            
            <form action="">
                <button class="button"><span>Lever modul </span></button>
            </form>

            <form action="Forum">
                <button class="button"><span>Forum </span></button>
            </form>

            <form action="Blog.jsp">
                <button class="button"><span>Blogg </span></button>
            </form>
        </div>
    </body>
</html>
