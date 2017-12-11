<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
        <title>Les tilbakemeldinger</title>
    </head>

    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Les tilbakemeldinger</h2>
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
                <%
                    String driverName = "com.mysql.jdbc.Driver";
                    String connectionUrl = "jdbc:mysql://localhost:3306/";
                    String dbName = "is_202";
                    String userId = "root";
                    String password = "root";
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
                    String id = request.getParameter("id");
                    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                    statement = connection.createStatement();
                    String sql = "SELECT * FROM is_202.Feedback where ModuleOppgaveID = '" + id + "'";
                    resultSet = statement.executeQuery(sql);
                    if (!resultSet.next()) {
                        out.println("Kunne ikke finne spørsmålet<br><br>");
                    } else {
                %>

                <table align="left" cellpadding="5" cellspacing="5" border="1">
                    <tr bgcolor="#848484">
                        <th>ID</th>
                        <th>Navn</th>
                        <th>Kategori</th>
                        <th>Spørsmål</th>
                    </tr>

                    <tr bgcolor="#BDBDBD">
                        <td> <%= resultSet.getString("ModuleOppgaveID")%> </td>
                        <td> <%= resultSet.getString("email")%> </td>
                        <td> <%= resultSet.getString("comment")%> </td>
                        <td> <%= resultSet.getString("rating")%> </td>
                    </tr>
                </table>
                <br>
                <%
                    }
                %>

            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>
