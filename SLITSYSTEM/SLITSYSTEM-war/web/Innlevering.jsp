<%-- 
    Document   : ModulListe
    Created on : 16.nov.2017, 13:03:52
    Author     : sindrethompson
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <title>Innlevering</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Innlevering</h2>
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
                    String id = request.getParameter("userId");
                    String driverName = "com.mysql.jdbc.Driver";
                    String connectionUrl = "jdbc:mysql://localhost:3306/";
                    String dbName = "IS_202";
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
                <table align="left" cellpadding="5" cellspacing="5" border="1">
                    <tr>

                    </tr>
                    <tr bgcolor="#FF123">

                        <td><b>Modulnnavn?</b></td>
                        <td><b>Fil</b></td>
                        <td><b>Kommentar</b></td>
                        <td><b>Levert av</b></td>
                    </tr>
                    <%
                        try {
                            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                            statement = connection.createStatement();
                            String sql = "SELECT * FROM Delivery";

                            resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                    %>
                    <tr bgcolor="#FF888">

                        <td><%=resultSet.getString("title")%></td>
                        <td><%=resultSet.getBlob("contents")%></td>
                        <td><%=resultSet.getString("comment")%></td>
                        <td><%=resultSet.getString("loginUser")%></td>

                    <a href="Download.jsp">Last ned</a>

                    <%
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>