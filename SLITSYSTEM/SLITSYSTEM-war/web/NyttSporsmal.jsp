<!DOCTYPE html>
<html>
    <head>
        <title>Nytt spørsmål</title> 
        <link rel="stylesheet" href="css.css">
        <meta charset="UTF-8">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>              
            </div>    
            <div class ="column header left">
                <h2>Nytt spørsmål</h2>
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
                <h3>Skriv ditt spørsmål</h3>
                <form method="post" action="/SLITSYSTEM-war/NewQuestionServlet"> 
                    <br>
                    Navn      :<input type="text" name="navn" placeholder="Skriv ditt navn.." autofocus/><br/><br/>
                    Kategori  :<input type="text" name="kategori" placeholder="Sriv kategori.." /><br/><br/>
                    Spørsmål  : <br>
                    <textarea name="QuestionText" rows="10" cols="25" placeholder="Skriv inn ditt spørsmål.."></textarea> <br><br>
                    <input type="submit" value="Post spørsmålet"/>        
                </form>   
                <div class="bottomheader"></div>
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>

