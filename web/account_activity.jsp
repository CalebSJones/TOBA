<%-- 
    Document   : account_activity
    Created on : Apr 12, 2017, 2:46:04 PM
    Author     : Caleb Jones
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Account Activity | TOBA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <h1>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</h1>
                        <p>View your account overview below.</p>
                    </c:when>
                    <c:otherwise>
                        <h1>Not Logged In</h1>
                        <p>Sorry, but you are not logged in to your account. Please <a href="login.jsp">login</a> to your account before continuing.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
