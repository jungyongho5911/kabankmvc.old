<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> 
<%@ page import = "java.util.*" %> 
 <body> 
 <%@ include file="../common/header.jsp" %> 
<%@ include file="../common/nav.jsp" %>
 <section>
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
  		
  	</table>
  	
  </article>
 </section>
 <%@ include file="../common/footer.jsp" %> 
 </body>
 
 </html>