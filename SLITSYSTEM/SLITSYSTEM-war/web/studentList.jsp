<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <title>Studentoversikt</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>      
    <div class ="row">
        <div class ="column venstreheader">
            <a href="Hovedmeny.jsp"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
            </a>  
        </div>
        <div class ="column header left"><h2>Studentliste</h2></div>
        <div class ="column header right"><h2>Bruker</h2></div>      
        <div class="venstre">
            <u1>
                <li><a href="studentList.jsp">Studentoversikt</a></li>
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
            
            <table width="250" align="left" cellpadding="5" cellspacing="5" cellpadding="5" border="0"  border-collapse="collapse">
                <tr bgcolor="#ffffff">
                <form method="post" action="studentListSearch.jsp">
                    <td><input type="text" name="search" placeholder="Søk etter student..."></td>
                    <td><input type="submit" value="Søk"></td>
                </form>
                </tr>
            </table>
            <div style = "clear:both;"></div>
            <br>
            <table align="left" cellpadding="5" cellspacing="5" cellpadding="5" border="0" bgcolor="#f1f4f9" border-collapse="collapse">
                <tr bgcolor="#ffffff">
                    <th width="250px">Epost</th>
                    <th width="250px">Navn</th>
                </tr>

                <%
                    try {
                        connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                        statement = connection.createStatement();
                        String sql = "SELECT * FROM Bruker where userType ='student'";

                        resultSet = statement.executeQuery(sql);
                        while (resultSet.next()) {
                %>

                <tr bgcolor="#ffffff">
                    <td width="250px"><%=resultSet.getString("email")%></td>
                    <td width="250px"><%=resultSet.getString("lName")%>, <%=resultSet.getString("fName")%></td>
                    <td><table>
                            <form method="post" action="UserPagePublic.jsp">
                                <input type="hidden" name="StudentListEmail" value=<%=resultSet.getString("email")%>>
                                <input type="submit" value="Gå til" style="width:100%">
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
        <div class="bottomheader"></div>
    </div>
</body>
