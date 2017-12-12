<%-- 
    Document   : Progressionplan
    Created on : 06.des.2017, 10:15:24
    Author     : RasmusRS
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
                <h2>Din plan for progresjon i faget</h2>
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
                    <li><a href="Progressionplan.jsp">Progresjonsplan</a></li>
                </u1>
            </div>

            <div class="midt">  
                <%
                    String id = request.getParameter("userId");
                    String driverName = "com.mysql.jdbc.Driver";
                    String connectionUrl = "jdbc:mysql://localhost:3306/";
                    String dbName = "is202";
                    String userId = "root";
                    String password = "rrs12345";

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

                        <td><b>KursNavn</b></td>
                        <td><b>Dine valgte frister</b></td>
                        <td><b>Din planlagte progresjon</b></td>
                    </tr>
                    <%
                        try {
                            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                            statement = connection.createStatement();
                            String sql = "SELECT * FROM Plan";

                            resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                    %>
                    <tr bgcolor="#ffffff">
                      <!--  <td width="100px">*<//%=resultSet.getString("planID")%></td> -->
                        <td width="100px"><%=resultSet.getString("courseName")%></td>
                        <td width="100px"><%=resultSet.getString("numbOfModules")%></td>
                        <td width="100px"><%=resultSet.getString("planningInfo")%></td>
                <!--    <form method="post" action="FinnMID.jsp">
                        <input type="hidden" name="id" value=<%=resultSet.getString("")%>>
                        <td><button name ="StudentKnapp" type="submit">Side for planer eller noe</button> </td>
                    </form>   -->
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
</html>
