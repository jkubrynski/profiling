<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>GC Tester</h1>

<p>GC Process created successfully.</p>
<form action="/gc/kill" method="GET">
    <p>
        <input type="submit" value="Kill it!" />
    </p>
</form>