<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> 
<%@ page import = "java.util.*" %> 
 <body> 
 <%@ include file="../common/header.jsp" %> 
<%@ include file="../common/nav.jsp" %>
 <section>
  <article>
 	<h1>비트캠프메인</h1>
  </article>
  <article>
  <form id="change_pass"action="${ctx}/<user class="do"></user>">
  <table style="margin-left: 180px" id="bitcamp_tabla2" >
  	<tr>
  		<td rowspan="4"><img src="<%=application.getContextPath() %>/resources/img/images.jpg" style="width : 250px; height:150px" alt=""  /></td>
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
  </table>
  </form>
  </article>
  <article>
  	<table id= "bitcamp_table" >
  		<tr>
  			<td>상태</td>
  			<td>월요일</td>
  			<td>화요일</td>
  			<td>수요일</td>
  			<td>목요일</td>
  			<td>금요일</td>
  			
  		</tr>
  		<tr>
  			<td>결석</td>
  			<td><input type="radio" name="monday" value="absent" checked/></td>
  			<td><input type="radio" name="tuesday" value="absent" checked/></td>
  			<td><input type="radio" name="wednesday" value="absent" checked/></td>
  			<td><input type="radio" name="thursday"value="absent" checked/></td>
  			<td><input type="radio" name="friday"value="absent" checked/></td>
  		</tr>
  		<tr>
  			<td>지각</td>
  			<td><input type="radio" name="monday" value="late" /></td>
  			<td><input type="radio" name="tuesday" value="late"/></td>
  			<td><input type="radio" name="wednesday"value="late"/></td>
  			<td><input type="radio" name="thursday"value="late"/></td>
  			<td><input type="radio" name="friday"value="late"/></td>
  		</tr>
  		<tr>
  			<td>조퇴</td>
  			<td><input type="radio" name="monday" value="early_leave"  /></td>
  			<td><input type="radio" name="tuesday" value="early_leave"/></td>
  			<td><input type="radio" name="wednesday"value="early_leave"/></td>
  			<td><input type="radio" name="thursday" value="early_leave"/></td>
  			<td><input type="radio" name="friday" value="early_leave"/></td>
  		</tr>
  		<tr>
  			<td>출석</td>
  			<td><input type="radio" name="monday" value="attend"  /></td>
  			<td><input type="radio" name="tuesday"  value="attend"/></td>
  			<td><input type="radio" name="wednesday"  value="attend"/></td>
  			<td><input type="radio" name="thursday"  value="attend"/></td>
  			<td><input type="radio" name="friday" value="attend"/></td>
  		</tr>
  		<tr>
  			<td>결과</td>
  			<td><input type="text" name="result"  /></td>
  			<td><input type="text" name="result" /></td>
  			<td><input type="text" name="result" /></td>
  			<td><input type="text" name="result" /></td>
  			<td><input type="text" name="result" /></td>
  		</tr>
  		<tr >
  			<td colspan="6">
  			<input type="hidden" name="" value="hong" />
  			<button id="attend_result"><h1>검  색</h1></button>
  			<input type="hidden" name="" value="hong" />
  			
  			<button id="pass_change_btn"><h1>비밀번호변경</h1></button></td>
  			
  		</tr>
  	</table>
  </article>
 </section>
 <%@ include file="../common/footer.jsp" %> 
 </body>
 <script>
 document.querySelector('#pass_change_btn').addEventListener('click',
			function() {
	 
		document.querySelector('#change_pass').submit();
	},false);
 </script>
 </html>