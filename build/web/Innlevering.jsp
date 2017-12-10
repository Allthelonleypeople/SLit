<%-- 
    Document   : ModulListe
    Created on : 16.nov.2017, 13:03:52
    Author     : sindrethompson
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    String id = request.getParameter("userId");
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "IS_202";
    String userId = "root";
    String password = "tH88jbdz";

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
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
   
    <a href="Download.html">download</a>

        <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
</table>