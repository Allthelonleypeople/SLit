<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Hent tabell</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
    </head>
    <body>
        <div class ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.jsp"><img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60"></a>
            </div>
            <div class ="column header left"><h2>Tabell</h2></div>
            <div class ="column header right"><h2>Bruker</h2></div>    
            <div class="venstre">
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
                <table align="left" cellpadding="5" cellspacing="5" border="1">
                    <tr>

                    </tr>
                    <tr bgcolor="#A52A2A">
                        <td><b>Delivery_ID</b></td>
                        <td><b>comment</b></td>
                        <td><b>Title</b></td>
                        <td><b>File</b></td>
                        <td><b>approved</b></td>
                    </tr>
                    <%
                        try {
                            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                            statement = connection.createStatement();
                            String sql = "SELECT * FROM delivery";

                            resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                    %>
                    <tr bgcolor="#DEB887">

                        <td><%=resultSet.getInt("Delivery_ID")%></td>
                        <td><%=resultSet.getString("comment")%></td>
                        <td><%=resultSet.getString("Title")%></td>
                        <td><%=resultSet.getBlob("File")%></td>
                        <td><%=resultSet.getBoolean("approved")%></td>

                    </tr>

                    <%
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
                <br><br><br><br>
                <a href="/SLITSYSTEM/Download.jsp">Nedlasting av fil</a>

            </div>
            <div class="bottomheader"></div>
        </div>
    </body>
</html>