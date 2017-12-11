<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="users.Bruker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Blog</title>
        <link rel="stylesheet" href="css.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div class ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>  
            </div>
            <div class ="column header left"><h2>Blog</h2></div>
            <div class ="column header right"><h2>Bruker</h2></div>     
            <div class="venstre">
                <u1>
                    <li><a href="Hovedmeny.jsp">Hovedside</a></li>
                    <li><a href="Moduler.jsp">Moduler</a></li>
                    <li><a href="Forum">Forum</a></li>
                    <li><a class="active" href="Blog.jsp">Blogg</a></li>                
                </u1>
            </div>
            <div class="midt">
                <%
                    String id = request.getParameter("userId");
                    String driverName = "com.mysql.jdbc.Driver";
                    String connectionUrl = "jdbc:mysql://localhost:3306/";

                    String dbName = "is_202";
                    String userId = "root";
                    String password = "root";

                    Bruker loggedInUser = (Bruker) session.getAttribute("loginUser");
                    String currentUserEmail = loggedInUser.getEmail();

                    try {
                        Class.forName(driverName);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    Connection connection = null;
                    Statement statement = null;
                    ResultSet resultSet = null;
                %>



                <%
                    try {
                        connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                        statement = connection.createStatement();

                        String sql = "SELECT * FROM is_202.poster WHERE loginUser = '" + currentUserEmail + "'";

                        resultSet = statement.executeQuery(sql);
                        while (resultSet.next()) {
                %>

                <div class="boxelns">
                    <h7><b><%=resultSet.getString("tittel")%></b></h7><br>
                    <h8><%=resultSet.getString("innhold")%></h8><br>
                </div>

                <%
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>

                <br>
                <h5>Skriv en ny post</h5>
                <form method="post" action="/SLITSYSTEM-war/NewPostServlet">
                    <input Type="hidden" name="currentUserEmail" value="<%=currentUserEmail%>">
                    Tittel : <input type="text" name="tittel"> <br>                
                    Innhold : <br>
                    <textarea name="innhold" rows="10" cols="25"></textarea> <br><br>
                    <input type="submit" value="Post"> <br>

                </form>
            </div>
            <div class="bottomheader"></div>            
        </div>
    </body>
</html>