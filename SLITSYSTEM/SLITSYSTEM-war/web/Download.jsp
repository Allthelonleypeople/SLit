<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Last ned fil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>            
            </div>    
            <div class ="column header left">
                <h2>Last ned</h2>
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
                <form method="get" action="DownloadServlet" enctype="multipart/form-data">
                    <table border="0">

                        <td>Fil_ID: </td>
                        <td><input type="text" name="Delivery_ID" size="50"/></td>

                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Send">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>
