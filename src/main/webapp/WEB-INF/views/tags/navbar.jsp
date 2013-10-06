<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
  <span class="icon-bar"></span>
  <span class="icon-bar"></span>
  <span class="icon-bar"></span>
</a>
<a class="brand" href="#">Profiling</a>
<div class="nav-collapse collapse">
  <ul class="nav">
    <li><a href="<c:url value="/" />">Home</a></li>
    <li><a href="<c:url value="/simple_mem_leak" />">Simple Memory leak</a></li>
    <li><a href="<c:url value="/complex_mem_leak" />">Complex Memory leak</a></li>
    <li><a href="<c:url value="/shops" />">Hibernate query</a></li>
    <li><a href="<c:url value="/shops/count" />">JDBC query</a></li>
    <li><a href="<c:url value="/gc" />">GC Tester</a></li>
  </ul>
</div>