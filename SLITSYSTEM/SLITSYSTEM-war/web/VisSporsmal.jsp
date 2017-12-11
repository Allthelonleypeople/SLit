<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <table align="left" cellpadding="5" cellspacing="5" border="0" bgcolor="#f1f4f9" border-collapse="collapse">
            <tr bgcolor="#ffffff">
                <th width="200px">Navn</th>
                <th width="200px">Kategori</th>
                <th width="500px">Spørsmål</th>
            </tr>
            <%
                try {
                    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                    statement = connection.createStatement();
                    String sql = "SELECT * FROM is_202.questions order by kategori, QuestionID";

                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
            %>
            <tr bgcolor="#ffffff">
                <td width="150px"><%=resultSet.getString("navn")%></td>
                <td width="150px"><%=resultSet.getString("kategori")%></td>
                <td width="500px"><%=resultSet.getString("QuestionText")%></td>
                <td align="center" bgcolor="#f1f4f9">
                    <table>
                        <form method="post" action="FinnQID.jsp">
                            <input type="hidden" name="id" value=<%=resultSet.getString("QuestionID")%>>
                            <input type="submit" value="Kommentarer" style="width:100%">
                            <!--<button name ="ForumKnapp" type="submit">Kommentarer</button> -->
                        </form>
                    </table>
                </td>
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