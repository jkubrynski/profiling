<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>GC Tester</h1>

<form action="/gc/create" method="POST">
    <p>
        <label for="threads">Thread num: </label>
        <input type="text" id="threads" name="threads" value="50" /><br />

        <label for="time">Clear time: </label>
        <input type="text" id="time" name="time" value="3000" /><br />

        <label for="size">Array size: </label>
        <input type="text" id="size" name="size" value="10000" /><br />

        <label for="init">Init data: </label>
        <input type="text" id="init" name="init" value="0" /><br />

        <label for="jvmargs">JVM args: </label>
        <textarea id="jvmargs" name="jvmargs">-Xmx500m -Xms500m -Xmn400m -XX:MaxTenuringThreshold=15 -XX:SurvivorRatio=2</textarea><br />

        <input type="submit" value="Create process" />
    </p>
</form>