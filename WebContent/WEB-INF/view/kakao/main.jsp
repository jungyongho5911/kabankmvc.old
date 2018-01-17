<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
 <%@ include file="../common/header.jsp" %> 
 <%@ include file="../common/nav.jsp" %> 
  <section>
  <article>
 <p>카카오메인</p>
 </article>
 <article>
 <table id="kakaoTable1">
 <tr >
 <td rowspan="2"><button name="create_bank" id="add_kakao_bank">통장개설</button></td>
 <td><button id="button">입금</button> </td>
 <td><button id="button">출금</button> </td>
 </tr>
 <tr>
 <td><button id="button">송금	</button> </td>
 <td><button id="button">해지</button> </td>
 </tr>
 </table>
 </article>
</section>	
 <%@ include file="../common/footer.jsp" %>  
 </body>
 <script>
 document.querySelector('#add_kakao_bank').addEventListener('click',
		 function () {
	 location.href ="${ctx}/kakao.do?cmd=account&dir=user&page=mypage";
		},false)
 </script>
 </html>