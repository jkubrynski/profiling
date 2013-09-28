<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>GC Tester</h1>

<form action="/gc/create" method="POST">
    <p>
        <label for="threads">Thread num: </label>
        <input type="text" id="threads" name="threads"/><br />

        <label for="time">Clear time: </label>
        <input type="text" id="time" name="time"/><br />

        <label for="size">Array size: </label>
        <input type="text" id="size" name="size"/><br />

        <label for="init">Init data: </label>
        <input type="text" id="init" name="init"/><br />

        <label for="jvmargs">JVM args: </label>
        <textarea id="jvmargs" name="jvmargs"></textarea><br />

        <input type="submit" value="Create process" />
    </p>
</form>