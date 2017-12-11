<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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

    String studentListEmail = request.getParameter("StudentListEmail");

    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
    statement = connection.createStatement();
    String sql = "SELECT email, fName, lName, password, userType, UserID, Description "
            + "FROM Bruker, UserPage "
            + "WHERE Bruker.email = UserPage.UserID "
            + "AND email = '" + studentListEmail + "'";

    resultSet = statement.executeQuery(sql);

    if (!resultSet.next()) {
        String sql2 = "Insert into UserPage(UserID, Description) values ('" + studentListEmail + "', 'Hei og velkommen til brukersiden.')";
        statement.executeUpdate(sql2);

        out.println("Brukersiden ble opprettet <br><br>");
%>

<form  method = "post" action = "UserPagePublic.jsp"> 
    <input type = "hidden" name = "StudentListEmail" value =<%= studentListEmail%>>
    <input type="submit" value="Gå til">
</form>

<%
} else {
%>

<body>
    <div class  ="row">
        <div class ="column venstreheader">
            <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
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
            <div>
                <table align="left" padding="5px" border="5" bordercolor="#f1f4f9">
                    <tr bgcolor="#ffffff">  
                        <th><%= resultSet.getString("fName")%> <%= resultSet.getString("lName")%></th>
                    </tr>
                    <div style = "clear:both;"></div>
                    <tr bgcolor="#ffffff">   
                        <td width="300" alignt="right"> <%= resultSet.getString("Description")%> </td>
                    </tr>
                </table>
                <form method="post" action="BlogPublic.jsp">
                    <input type="hidden" name="userBlog" value="<%= resultSet.getString("UserID")%>">
                    <div style = "clear:both;"></div> <br>
                    <input type="submit" value="Blog">
                </form>
            </div>
            <div style = "clear:both;"></div>

            <%
                }
            %>
        </div>
        <div class="bottomheader"></div>
    </div>
</body>
