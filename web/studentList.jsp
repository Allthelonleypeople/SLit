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
    String dbName = "IS202";
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

        <td><b>Epost</b></td>
        <td><b>Fornavn</b></td>
        <td><b>Etternavn</b></td>
    </tr>
    <%
        try {
            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM Bruker where userType ='student'";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
    %>
    <tr bgcolor="#FF888">

        <td><%=resultSet.getString("email")%></td>
        <td><%=resultSet.getString("fName")%></td>
        <td><%=resultSet.getString("lName")%></td>
        <form method="post" action="studentList.jsp">
        <input type="hidden" name="id" value=<%=resultSet.getString("email")%>>
        <td><button name ="StudentKnapp" type="submit">Studentside</button> </td>
        </tr>

        <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
</table>