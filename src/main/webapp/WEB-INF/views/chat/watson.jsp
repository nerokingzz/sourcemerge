<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
<script
	src="https://web-chat.global.assistant.watson.appdomain.cloud/loadWatsonAssistantChat.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>


</head>

<body>
<h1>
	Bookphago v0.001 
</h1>
	<br>
	<div id = "status" style = "font-weight:bold;">현재 상태 : 비회원</div><br>
	로그인 하시겠습니까?<br><br>
	<button id = "login">네 ^-^~~~~~~~</button>
</body>
<script src = "resources/chat/js/watsonjs.js" ></script>
</html>
