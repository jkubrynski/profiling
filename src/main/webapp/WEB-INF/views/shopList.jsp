<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Shops</h1>
<table class="table table-hover table-bordered">
  <thead>
  <tr>
    <th>#</th>
    <th>Name</th>
    <th>Website URL</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${shops}" var="shop">
    <tr>
      <td><c:out value="${shop.id}"/></td>
      <td><c:out value="${shop.name}"/></td>
      <td><c:out value="${shop.websiteUrl}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
