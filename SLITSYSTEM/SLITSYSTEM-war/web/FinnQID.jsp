<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<head>
    <title>Finn QuestionID</title>
    <link rel="stylesheet" href="css.css">
</head>

<body>
    <div class  ="row">
        <div class ="column venstreheader">
            <a href="Hovedmeny.html"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
            </a>
        </div>    
        <div class ="column header left">
            <h2>Valgt spørsmål</h2>
        </div>
        <div class ="column header right"> 
            <h2>Bruker</h2>
        </div>
    </div>
    <div class ="venstre">
    </div>
    <div class="midt">     
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

            String id = request.getParameter("id");

            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM is_202.questions where QuestionID = '" + id + "'";
            String sql2 = "SELECT * FROM is_202.comments where QuestionID = '" + id + "'";

            resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                out.println("Kunne ikke finne spørsmålet<br><br>");
                out.println("<a href=\"VisSporsmal.jsp\">Prøv igjen</a>");
            } else {
        %>
        <table align="left" cellpadding="5" cellspacing="5" cellpadding="5" border="0" bgcolor="#f1f4f9" border-collapse="collapse">
            <tr bgcolor="#ffffff">
                <th width="200px">Navn</th>
                <!--<th width="200px">Kategori</th>-->
                <th width="500px">Spørsmål</th>
            </tr>
            <tr bgcolor="ffffff">
                <td width="200"> <%= resultSet.getString("navn")%> </td>
                <!--<td width="100"> <%//= resultSet.getString("kategori")%> </td>-->
                <td width="600"> <%= resultSet.getString("QuestionText")%> </td>
            </tr>
        </table>
        <br>
        <%
            }
        %>
        <form method="post" action="/SLITSYSTEM-war/NewCommentServlet">
            <div style = "clear:both;"></div>
            <br>
            <u2>Kommentar:</u2> <br>        
            <textarea style="resize:none" name="QuestionComment" rows="10" cols="70"></textarea> <br><br>
            <u2>Navn:</u2> <br>
            <input type="text" name="KommentarNavn"
                   <br>
            <input type="hidden" name="QuestionID" value=<%= resultSet.getString("QuestionID")%>> <br>
            <input type="submit" value="Legg igjen kommentar">
        </form>
        <table align="left" cellpadding="5" cellspacing="5" cellpadding="5" border="0" bgcolor="#f1f4f9" border-collapse="collapse">          
            <%
                try {
                    resultSet = statement.executeQuery(sql2);
                    while (resultSet.next()) {
            %> 
            <tr bgcolor="#ffffff"> 
                <td width="200"> <%= resultSet.getString("KommentarNavn")%> </td>
                <td width="600"> <%= resultSet.getString("QuestionComment")%> </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>
        <div style = "clear:both;"></div>
    </div>
</body>


