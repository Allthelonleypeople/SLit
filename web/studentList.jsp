<%-- 
    Document   : ModulListe
    Created on : 16.nov.2017, 13:03:52
    Author     : sindrethompson and RasmusRS
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<head>
    <title>Se spørsmål</title>
</head>
<body>
    <link rel="stylesheet" href="css.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">       
<div class ="row">
    <div class ="column venstreheader">
        <a href="Hovedmeny.html"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
        </a>  
    </div>
    <div class ="column header left"><h2>Spørsmål</h2></div>
    <div class ="column header right"><h2>Bruker</h2></div>
</div>       
<div class="venstre"></div>
<div class="midt">
<%
    String id = request.getParameter("userId");
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "IS202";
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
<h2 align="center"><font><strong>Liste over alle studentene</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
    <tr>

    </tr>
    <tr>

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
    <tr>
        <td><%=resultSet.getString("email")%></td>
        <td><%=resultSet.getString("fName")%></td>
        <td><%=resultSet.getString("lName")%></td>
        <form method="post" action="studentList.jsp">
        <input type="hidden" name="id" value=<%=resultSet.getString("email")%>>
        <button name ="StudentKnapp" type="submit">Studentside</button> 
        </tr>

        <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
</table>
</div>
</body>