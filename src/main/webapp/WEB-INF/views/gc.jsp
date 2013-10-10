<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    function setValues(threads, time, size, init, jvmargs) {
        document.getElementById("threads").value = threads;
        document.getElementById("time").value = time;
        document.getElementById("size").value = size;
        document.getElementById("init").value = init;
        document.getElementById("jvmargs").value = jvmargs;
    }

    function flightRecorder() {
        setValues(20, 3000, 10000, 0, "-XX:+UnlockCommercialFeatures -XX:+FlightRecorder");
    }

    function serialGC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseSerialGC -Xmx500m");
    }

    function parallelGC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelGC -Xmx500m -XX:ParallelGCThreads=");
    }

    function parallelOldGC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -XX:ParallelGCThreads=");
    }

    function concMarkSweepGC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseConcMarkSweepGC -Xmx500m");
    }

    function g1GC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseG1GC -Xmx500m");
    }

    function g1GC() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseG1GC -Xmx500m");
    }

    function xmx() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx -Xms");
    }

    function xmxxms() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx -Xms");
    }

    function xmn() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -Xms500m -Xmn450m");
    }

    function survivorRatio() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -XX:SurvivorRatio=");
    }

    function maxTenuringThreashold() {
        setValues(50, 300, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -XX:MaxTenuringThreshold=");
    }

    function occupancyFraction() {
        setValues(50, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -XX:CMSInitiatingOccupancyFraction=");
    }

    function maxG1Pause() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseG1GC -Xmx500m -XX:MaxGCPauseMillis=");
    }

    function competition() {
        setValues(20, 1000, 20000, 5000000, "-server -XX:+UseParallelOldGC -Xmx500m -Xms500m");
    }

    function logsYoung() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -verbose:gc -Xloggc:gclogs.txt -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime");
    }

    function logsParallelOld() {
        setValues(20, 3000, 100000, 0, "-server -XX:+UseParallelOldGC -Xmx500m -verbose:gc -Xloggc:gclogs.txt -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime");
    }

    function logsMarkSweep() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseConcMarkSweepGC -Xmx500m -verbose:gc -Xloggc:gclogs.txt -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime");
    }

    function logsG1() {
        setValues(20, 3000, 10000, 0, "-server -XX:+UseG1GC -Xmx500m -verbose:gc -Xloggc:gclogs.txt -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime");
    }
</script>

<h1>GC Tester</h1>

<div style="width:50%; float:left">
<form action="/gc/create" method="POST">
    <p>
        <label for="threads">Thread num: </label>
        <input type="text" id="threads" name="threads" value="0" /><br />

        <label for="time">Clear time: </label>
        <input type="text" id="time" name="time" value="0" /><br />

        <label for="size">Array size: </label>
        <input type="text" id="size" name="size" value="0" /><br />

        <label for="init">Init data: </label>
        <input type="text" id="init" name="init" value="0" /><br />

        <label for="jvmargs">JVM args: </label>
        <textarea id="jvmargs" name="jvmargs"></textarea><br />

        <input type="submit" value="Create process" />
    </p>
</form>
</div>
<div style="width:50%; float:left">
    <input type="button" value="JMC Flight Recorder" onclick="flightRecorder()" /><br style="line-height:1cm"/>
    <input type="button" value="Serial GC" onclick="serialGC()" /><br style="line-height:1cm"/>
    <input type="button" value="Parallel GC" onclick="parallelGC()" /><br style="line-height:1cm"/>
    <input type="button" value="Parallel Old GC" onclick="parallelOldGC()" /><br style="line-height:1cm"/>
    <input type="button" value="Concurrent Mark-Sweep GC" onclick="concMarkSweepGC()" /><br style="line-height:1cm"/>
    <input type="button" value="G1 GC" onclick="g1GC()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise Xmx" onclick="xmx()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise Xmx Xms" onclick="xmxxms()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise Xmn" onclick="xmn()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise Survivor Ratio" onclick="survivorRatio()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise Tenuring Threshold" onclick="maxTenuringThreashold()" /><br style="line-height:1cm"/>
    <input type="button" value="Occupancy fraction" onclick="occupancyFraction()" /><br style="line-height:1cm"/>
    <input type="button" value="Exercise G1 Max GC Pause Millis" onclick="maxG1Pause()" /><br style="line-height:1cm"/>
    <input type="button" value="Competition" onclick="competition()" /><br style="line-height:1cm"/>
    <input type="button" value="Logs Young GC" onclick="logsYoung()" /><br style="line-height:1cm"/>
    <input type="button" value="Logs Parallel Old GC" onclick="logsParallelOld()" /><br style="line-height:1cm"/>
    <input type="button" value="Logs Concurrent Mark-Sweep GC" onclick="logsMarkSweep()" /><br style="line-height:1cm"/>
    <input type="button" value="Logs G1 GC" onclick="logsG1()" /><br style="line-height:1cm"/>
</div>