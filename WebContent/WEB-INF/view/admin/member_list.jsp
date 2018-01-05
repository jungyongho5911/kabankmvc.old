<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> 
<%@ page import = "java.util.*" %> 

<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body id="body">
<div id="wrapper">
	<header id="main_header">
		<h1>관리자 메인 페이지</h1>
	</header>
<aside id="main_aside">
	<ul>
	<li>관리자화면</li>
	<li><a href="#">회원관리</a></li>
	</ul>
</aside>
<section id="main_section">
		<table id="main_table">
		<tr>
		<th>
		<select >
		<option>ID</option>
		<option>이름</option>
		<option>성별</option>
		</select>
		</th>
		 <th colspan="5"><input id= "member_button1" type="text" /></th>
		 <th colspan="2"> <button id = "member_button2">검색</button></th>
		</tr>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
			</tr>
			<tr>
			<th colspan="8"><button id="add_member_btn">추가</button></th>
			</tr>
		</table> 	  
</section>	
</div>
<%@ include file="../common/footer.jsp" %> 
</body>
<script src="../../js/admin/member_list.js"></script>
</html>
   