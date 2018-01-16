<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="../common/header.jsp" %> 
<%@ include file="../common/nav.jsp" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경</title>
</head>
<body>
	<h1>비밀번호 변경하기</h1>
	<input id="current_pass" type="text" value="${sessionScope.user.pass}" /> 현재 비밀번호<br />
	
	<form id="chage_pass_form" action="${ctx}/user.do">
	<input id="change_pass" name="change_pass" type="text" /> 	수정할 비밀번호<br />
	<input id="confirm_pass" type="text" />	수정할 비밀번호확인<br />
	
	<input type="hidden" name="cmd" value="change_pass" />
	<input type="hidden" name="dir" value="bitcamp" />
	<input type="hidden" name="page" value="main" />
	
	</form>
	
	<button style="width:180px; height:100px;" id="confirm_btn">변경</button>
	<button style="width:180px; height:100px;" id="cancle_btn">취소</button>
	<h1>${sessionScope.user.id}</h1>
</body>
<script>
document.querySelector('#confirm_btn').addEventListener('click',
		function(){
	document.querySelector('#chage_pass_form').submit();

	
},false);
document.querySelector('#cancle_btn').addEventListener('click',
		function(){
	
},false);
</script>
</html>
   