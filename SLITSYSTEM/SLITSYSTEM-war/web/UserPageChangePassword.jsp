<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="users.Bruker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Endre passord</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Endre passord</h2>
            </div>
            <div class ="column header right"> 
            </div>   
            <div class ="venstre">
            </div>
            <div class ="midt">

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
                    
                    Bruker loggedInUser = (Bruker) session.getAttribute("loginUser");
                    String currentUserEmail = loggedInUser.getEmail();

                    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                    statement = connection.createStatement();
                    String sql = "SELECT email, fName, lName, password, userType, UserID, Description "
                            + "FROM Bruker, UserPage "
                            + "WHERE Bruker.email = UserPage.UserID "
                            + "AND email = '" + currentUserEmail + "'";

                    resultSet = statement.executeQuery(sql);
                    
                    

                    if (!resultSet.next()) {
                        out.println("Kunne ikke opprette bruksersiden <br><br>");
                        out.println("<a href=\"Hovedmeny.jsp\">Prøv igjen</a>");
                    } else {
                %>

                <head>
                    <title><%= resultSet.getString("UserID")%>  </title>
                </head>
                <h3>Skriv inn nytt passord</h3>
                <h5>(max 20 tegn)</h5>
                <form method="post" action="UserPagePasswordUpdated.jsp">
                    <input type="password" style="resize:none" name="NyttPassord" rows="1" cols="20" maxlength="20"></textarea>
                    <br><br>
                    <input type="submit" value="Oppdater"/>
                </form>
                <div style = "clear:both;"></div>

                <%
                    }
                %>

            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>