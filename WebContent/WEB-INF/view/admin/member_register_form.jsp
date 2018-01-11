<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
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
	<form id="member_register_form" action="member_register.jsp">
		<table id="main_table">
		<tr>
			<td> id:  <input id="table_id" name="id"  type="text" /></td>
		<tr>
			<td> pass:  <input id="table_id" name="pass"  type="text" /></td>
		</tr>
		
		<tr>
			<td>이름 : <input id="table_name" name="name" type="text" /></td>
		</tr>
		<tr>
			<td>SSN : <input id="table_ssn" name="ssn" type="text" /></td>
		</tr>
		<tr>
			<td>전화번호 : <input id="table_phone" name="phone" type="text" /></td>
		</tr>
		<tr>
			<td>주소 : <input id="table_addr" name="addr" type="text" /></td>
		</tr>
		<tr>
			<td>이메일 : <input id="table_email" name="email" type="text" /></td>
		</tr>
			<tr>
			<td><button id="member_register_btn" style="width:150px; height:30px;margin-left: 80%;"> 추가 </button></td>
			</tr>
		</table> 
	</form>	  
</section>	
</div>
</body>
<script src="../../js/admin/member_register_form.js"></script>
<%@ include file="../common/footer.jsp" %> 
</html>
   
   