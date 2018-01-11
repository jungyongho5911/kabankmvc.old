<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>	
	<meta charset="UTF-8" />	
	<title>main</title>
	
</head>
<body>
	<header id="index_header">
		<h1>BIT CAMP MAIN</h1>
	</header>
<div id="wrapper">
	<section id="index_table">
		<article>
			<table id="index_table">
		<tr id="first_child">
			<td colspan="5">
				<form id="main_go"action="${ctx}/user/auth.do">
					<table id="index_login_box" >					
			<tr>
			 		<td> 
			 		<input id="index_input_id" name="index_input_id" value="aaa" type="text" placeholder="id"/>
			</td>
			 	<td rowspan="2">
				 <button id="index_login_btn">로그인</button>
			</td>
			 </tr>
			 <tr>
				<td>
			 	<input id="index_input_pass" type="text" name="index_input_pass" value="aaa" placeholder="pass"/>
			 	</td >
			 	</tr>
		</table>	 	
	</form>
		 	<a id="go_admin_link" href="#" > 관리자</a>
			<a id="go_join_link" href="#"> 회원가입 </a>	  		
			<a id="go_jdbc_link" href="#"> JDBCTest </a>	  		
		</td>
	</tr>	
	</table>
		</article>
	</section>
</div>
</body>
<script>
document.querySelector('#go_admin_link').addEventListener('click',
		function(){
	location.href="${ctx}/admin/main.do";
},false);
document.querySelector('#go_join_link').addEventListener('click',
		function(){
	location.href ="${ctx}/user/join.do";
},false);

document.querySelector('#go_jdbc_link').addEventListener('click',
		function () {
	location.href="${ctx}/common/jdbc_test.do"
},false);
document.querySelector('#index_login_btn').addEventListener('click',
		function() {
	document.querySelector('#main_go').submit();
},false);

	

</script>
</html>
   