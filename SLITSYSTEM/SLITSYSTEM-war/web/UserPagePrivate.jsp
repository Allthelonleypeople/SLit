<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="users.Bruker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        String sql2 = "Insert into UserPage(UserID, Description) values ('tar', 'Hei og velkommen til brukersiden.')";
        statement.executeUpdate(sql2);

        out.println("Brukersiden ble opprettet <br><br>");
%>

<form  method = "post" action = "UserPagePublic.jsp"> 
    <input type = "hidden" name = "StudentListEmail" value ="tar">
    <input type="submit" value="Gå til">
</form>

<%
} else {
%>

<body>
    <div class  ="row">
        <div class ="column venstreheader">
            <a href="Hovedmeny.jsp"> <img src="C:\Users\Tarjei\Documents\GitHub\SLit\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
            </a>
        </div>    
        <div class ="column header left">
            <h2>Brukerside</h2>
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

            <head>
                <title><%= resultSet.getString("UserID")%></title>
                <link rel="stylesheet" href="css.css">
            </head>
            <div style="float:left; width: 70%;">
                <form action="ModulListe.jsp">
                    <button class="button"><span>Moduloversikt</span></button>
                </form>
                <div style = "clear:both;"></div>
                <form action="Forum">
                    <button class="button"><span>Foruminnlegg</span></button>
                </form>
                <div style = "clear:both;"></div>
                <form action="Blog.jsp">
                    <button class="button"><span>Din Blogg</span></button>
                </form>
                <div style = "clear:both;"></div>
                <form action="">
                    <button class="button"><span>Meldinger</span></button>
                </form>
            </div>
            <div style="float:right;">
                <table align="right" padding="5px" border="5" bordercolor="#f1f4f9">
                    <tr align="center"> 
                    <img src="C:\Users\Tarjei\Documents\It og informasjonssystemer\3 Semester\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\images\UserPageIcon.png" alt="UserIcon" width="80" height="100"> 
                    </tr>
                    <tr bgcolor="#ffffff">  
                        <th><%= resultSet.getString("fName")%> <%= resultSet.getString("lName")%></th>
                    </tr>
                    <div style = "clear:both;"></div>
                    <tr bgcolor="#ffffff">   
                        <td width="300" alignt="right"> <%= resultSet.getString("Description")%> </td>
                    </tr>
                </table>
                <div style = "clear:both;"></div>
                <a href="UserPageChangePassword.jsp" align="right">Endre passord</a>
            </div>
            <div style = "clear:both;"></div>

            <%
                }
            %>
        </div>
        <div class="bottomheader"></div>
    </div>
</body>
