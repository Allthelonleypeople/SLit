<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
    </head>

    <body>
        <h1>Viser valgt spørsmål</h1>

        <%
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "is_202";
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

        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr bgcolor="#848484">
            <meta charset="UTF-8">
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
