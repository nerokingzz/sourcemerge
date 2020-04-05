<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 신청 내역</title>
</head>

	<%
		session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		String user_position=(String)session.getAttribute("user_position");
	%>

<body>
	
	<c:choose>
	
		<%-- 일반회원용 리스트 --%>
		<c:when test="${user_position eq 'general'}"> <!-- eq : == -->
			<h3>${user_id}님의 커뮤니티 신청 내역</h3>
			<c:choose>
				<c:when test="${requestListSize gt 0}">	<!-- gt : > -->  
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>이름</th>
								<th>분류</th>
								<th>설명</th>
								<th>목적</th>
								<th>상태</th>
							</tr>
						
							<c:forEach var="i" begin="1" end="${requestListSize}">
								<tr>
									<td>${i}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_ESTABLISH_DATE")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_NAME")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_CATEGORY")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_DESCRIPTION")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_AIM")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_ESTABLISH_STATUS")}</td>
								</tr>
							</c:forEach>
						</thead>
					</table>
				</c:when>
			</c:choose>
		</c:when>
		
		<%-- 관리자용 리스트 --%>
		<c:when test="${user_position eq 'admin'}"> <!-- eq : == -->
			<h3>커뮤니티 신청 내역</h3>
			
			<c:choose>
				<c:when test="${requestListSize gt 0}">	<!-- gt : > -->  
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>이름</th>
								<th>분류</th>
								<th>설명</th>
								<th>목적</th>
								<th>상태</th>
								<th>확인</th>
							</tr>
						
							<c:forEach var="i" begin="1" end="${requestListSize}">
								<tr>
									<td>${i}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_ESTABLISH_DATE")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_NAME")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_CATEGORY")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_DESCRIPTION")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_AIM")}</td>
									<td>${requestList.get(i-1).get("COMMUNITY_ESTABLISH_STATUS")}</td>
									<td><button class="stsUpBtn" onclick="">변경</button></td>
								</tr>
							</c:forEach>
						</thead>
					</table>
				</c:when>
			</c:choose>
		</c:when>

		
		

	</c:choose>

</body>
</html>