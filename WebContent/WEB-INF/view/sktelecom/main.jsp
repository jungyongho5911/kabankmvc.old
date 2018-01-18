<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
 <%@ include file="../common/nav.jsp" %> 
  <%@ include file="../common/header.jsp" %> 
 <section>
 <article>
 <p>SKT메인</p>
 </article>
 <article>
 <table>
 <tr>
 <td><button id="phone_create_btn">폰번호생성</button></td>
 <td><button>날짜생성</button></td>
 </tr>
 </table>
 </article>
 </section>
 <%@ include file="../common/footer.jsp" %>  
 </body>
 <script>
 document.querySelector('#phone_create_btn').addEventListener('click',
		 function () {
	location.href = "${ctx}/phone.do?cmd=phone_numbur&dir=user&page=mypage";
		},false)
 </script>
 </html>