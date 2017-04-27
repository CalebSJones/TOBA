<%-- 
    Document   : transaction
    Created on : Apr 12, 2017, 2:48:58 PM
    Author     : Caleb Jones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA - Titan Online Banking Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <h1>Transaction Page</h1>
                <table>
                    <tr>
                        <th>Type</th>
                        <th>Balance</th>
                    </tr>
                  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                  <c:forEach var="account" items="${accounts}">
                      <tr>
                          <td>${account.type}</td>
                          <td>${account.balance}</td>
                      </tr>
                  </c:forEach>
                </table>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
