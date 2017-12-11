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

    String NyttPassord = request.getParameter("NyttPassord");

    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
    statement = connection.createStatement();

    String sql = "UPDATE Bruker SET password = '" + NyttPassord + "' WHERE email = 'tar'";

    statement.executeUpdate(sql);
%>
<head>
    <title>Vellykket</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
    <div class  ="row">
        <div class ="column venstreheader">
            <a href="Hovedmeny.html"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
            </a>
        </div>    
        <div class ="column header left">
            <h2></h2>
        </div>
        <div class ="column header right"> 
        </div>
    </div>      
    <div class ="venstre" padding="20px">
    </div>
    <div class ="midt">
        <h3>Endring av passord vellykket!</h3>
        <form action="UserPage.jsp">
            <button class="button"><span>Returner</span></button>
        </form>
    </div>
    <div style = "clear:both;"></div>
</body>
