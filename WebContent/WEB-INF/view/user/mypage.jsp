<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/nav.jsp" %>
 <%@ include file="../common/header.jsp" %> 
<h1>마이페이지</h1>
<body>
	

  <article>
  <table style="margin-left: 180px" id="bitcamp_tabla2" >
  	<tr>
  		<td rowspan="6"><img src="<%=application.getContextPath() %>/resources/img/images.jpg" style="width : 250px; height:250px" alt=""  /></td>
  		<td class="column">id</td>
  		<td class="member">${sessionScope.user.id}</td>
  		<td class="column">이름</td>
  		<td class="member">${sessionScope.user.name}</td>
  	</tr>
  	<tr>
  		<td class="column">비밀번호</td>
  		<td class="member">${sessionScope.user.pass}</td>
  		<td class="column">생일</td>
  		<td class="member">${sessionScope.user.ssn}</td>
  	</tr>
  	<tr>
  		<td class="column">phone</td>
  		<td class="member">${sessionScope.user.phone}</td>
  		<td class="column">이메일</td>
  		<td class="member">${sessionScope.user.email}</td>
  	</tr>
  	<tr>
  		<td class="column">성별</td>
  		<td class="member">${sessionScope.user.ssn}</td>
  		<td class="column">주소</td>
  		<td class="member">${sessionScope.user.addr}</td>
  	</tr>
  		<tr>
  		<td class="column">ACCOUNT</td>
  		<td class="member">${sessionScope.user.account.accountnum} </td>
  		<td class="column">CUSTOMNUM</td>
  		<td class="member">${sessionScope.user.account.customnum}</td>
  	</tr>
  		<tr>
  		<td class="column">폰넘버</td>
  		<td class="member">${sessionScope.user.phoneBean.phoneNumber} </td>
  		<td class="column">개통날짜</td>
  		<td class="member">${sessionScope.user.phoneBean.regdate}</td>
  	</tr>
  	<tr >
  			<td colspan="6">
  			<button id="pass_change_btn"><h1>비밀번호변경</h1></button>
  			<button id="leave_btn"><h1>탈퇴</h1></button></td>
  		</tr>
  </table>
  </article>
  </body>
   <%@ include file="../common/footer.jsp" %> 
  <script>
 document.querySelector('#pass_change_btn').addEventListener('click',
			function() {
	 location.href ="${ctx}/user.do?cmd=main&page=change_pass";
	},false);
 document.querySelector('#leave_btn').addEventListener('click',
			function() {
	location.href = "${ctx}/user.do?cmd=leave&data=${sessionScope.user.id}";
	},false);
 </script>
  </html>
  