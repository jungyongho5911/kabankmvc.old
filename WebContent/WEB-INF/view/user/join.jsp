<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
 <%@ include file="../common/header.jsp" %> 
  <div id = "wrapper">
 <section>
 	<header style="text-align: center;" >
 		<hgroup>
 	       <h1 > 비트캠프 회원가입</h1>
 		</hgroup>
 	</header>
 	 <article>
 	<form  id="join_form" action="${ctx}/user.do">
 		<table  style="margin: 0 auto" id="member_table" >
 			<tr >
 				<td> id : <input  id="join_id" name="id"type="text" />
 				<button id="check_dupl_btn" name="check_dupl_btn">중복확인</button>
 				</td>
 			</tr>
 			<tr>
 				<td>이름 : <input  id="join_name" name="name"type="text"  /></td>
 			</tr>
 			<tr>
 				<td>비밀번호 :<input id="join_pass" name="pass"  type="password"  /></td>
 			</tr>
 			<tr>
 				<td>이메일:<input type="email" name="email" />@
 				<select name="">
 				<option value="">naver.com</option>
 				<option>daum.net</option>
 				<option>nate.com</option>
 				</select>
 				</td>
 			<tr>
 				<td>가입일 : <input  type="date" /></td>
 			</tr>
 			<tr>
 			<tr>
 				<td>주민번호 :<input type="text" name="ssn" /></td>
 			</tr>
 			<tr>
 				<td>
 				<input type="radio"  /> SKT
 				<input type="radio"  /> LG
 				<input type="radio"  /> KT<br/>
 				- 핸드폰번호 :
 				<select>
 				<option>010</option>
 				</select>
 				<input pattern="[0-9]{4}" type="tel" name="phone"/> -  <input pattern="[0-9]{4}" type="tel" />
 				</td>
 			</tr>
 			<tr>
				<td>
				주소 : <input type="button" value="주소검색" />-<input style="width: 300px "type="text" name="addr" />
 				</td>
 			</tr>
 			<tr>
 			<td colspan = "2"> 
 				<input type="hidden" name="cmd" value="join" />
				<input type="hidden" name="dir" value="user" />
				<input type="hidden" name="page" value="login" />
 				<button  id="join_confirm_btn"style="width: 160px; height: 30px">회원가입</button> 
 				<button style="width: 160px; height: 30px">취소</button>
 			</td>
 			</tr>
 		</table>
 		</form>
 </article>
 </section>
</div>
 <%@ include file="../common/footer.jsp" %>
</body>
<script>
	document.querySelector('#join_confirm_btn').addEventListener('click',
			function () {
		documnet.querySelector('#join_form').submit();		
			},false);
</script> 
</html> 