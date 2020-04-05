<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 신청 양식 작성</title>
</head>   

	<%
		session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
	%>

<body>

	<h3>커뮤니티 신청하기</h3>
	<form action="com_esta_request.do" method="post">
		커뮤니티 이름<input type="text" name="community_name"> <br>
		운영자ID<input type="text" name="community_captain" value="${user_id}"> <br>
		신청날짜<input type="text" id="current_info" name="community_establish_date"> <br> <!-- hidden으로 변경 -->
		<select name="community_category">
			<option value="BO">--분류--</option>
			<option value="BO000">총류</option> 
			<option value="BO001">철학</option>
			<option value="BO002">종교</option>
			<option value="BO003">사회과학</option>
			<option value="BO004">자연과학</option>
			<option value="BO005">기술과학</option>
			<option value="BO006">예술</option>
			<option value="BO007">언어</option>
			<option value="BO008">문학</option>
			<option value="BO009">역사</option>
		</select> <br>
		설명<input type="text" name="community_description"> <br>
		목적<input type="text" name="community_aim"> <br>
		회원수<input type="text" name="community_member_count" value="0"> <br> <!-- hidden으로 변경 -->
		상태<input type="text" name="community_establish_status" value="진행중"> <br> <!-- hidden으로 변경 -->
		
		<input type="submit" value="신청하기">
		<input type="reset" value="다시작성">
	</form>


<script type="text/javascript">

	//현재 날짜 가져오기
	var date=new Date();
	var current=date.getFullYear() + '년' + (date.getMonth()+1) + '월' + date.getDate() + '일' + date.getHours() + '시' + date.getMinutes() + '분'  +  date.getSeconds() + '초';
	document.getElementById('current_info').value=current;
</script>
</body>
</html>