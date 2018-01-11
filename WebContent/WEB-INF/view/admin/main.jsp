<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<div id="wrapper">
	<header id="main_header">
		<h1>관리자 메인 페이지</h1>
	</header>
<aside id="main_aside">
	<a id="member_mgmt_link">회원관리</a>
</aside>
<section id="main_section">
		<table id="main_table">
			<tr>
				<td id="member_td">
					<button id="admin_list">맴버리스트</button> 
				</td>
				<td id="member_td">
					<button id="create_table_btn">테이블</button> 
				</td>
				<td id="member_td">
					<button id="create_table_btn">테이블</button> 
				</td>
			</tr>
			<tr>
				<td id="member_td">
					<button id="create_table_btn1">테이블</button> 
				</td>
				<td id="member_td">
					<button id="create_table_btn1">테이블</button> 
				</td>
				<td id="member_td">
						테이블 생성<br/>
				<form id="go_member_list"action="${pageContext.request.contextPath}/admin/create_table.do">	
					<select name="table_name" id="table_name">
						<option id="option" value="member"> 회원테이블 </option>
						<option id="option"value="attend" >출석테이블 </option>
					</select>
					<button id="admin_create_btn"> 생 성 </button>
				</form>  
				</td>
			</tr>
		</table> 	
		
</section>	
</div>
<%@ include file="../common/footer.jsp" %> 
</body>
<script>
document.querySelector('#admin_list').addEventListener('click',
		function(){
	location.href="${pageContext.request.contextPath}/admin/list.do";
},false);
document.querySelector('#admin_create_btn').addEventListener('click',
		function(){
	documetn.querySelector("#go_member_list").submit();
},false);
</script>
</html>
   