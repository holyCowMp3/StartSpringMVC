<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello SPRING MVC</h2>
<h6>simple page with person table</h6>
<spring:form commandName="person" method="GET">
    <spring:input path="name"></spring:input>
    <spring:password path="surname"></spring:password>
    <h1>${message}  </h1>
    <button formmethod="POST" formaction="add"> add </button>
    <button formmethod="POST" formaction="login"> login </button>
    <button formmethod="POST" formaction="showTable"> show table </button>
    <button formmethod="POST" formaction="clear"> clear </button>
</spring:form>
<table>
    <tr>
        <c:forEach var = "persons" items = "${tableView}">
    <tr>
            <td>
                <c:out value="${persons.name} "/>
            </td>
            <td>
                <c:out value="${persons.surname} "/>
            </td>
    <tr>
        </c:forEach>
    </tr>
</table>
</body>

</html>
