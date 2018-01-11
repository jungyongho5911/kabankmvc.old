<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
 <%@ include file="../common/nav.jsp" %> 
 <%@ include file="../common/header.jsp" %> 
<section>
<article>
 <form action="result.jsp">
 	구매금액: <input type="text" name="money" placeholder="게임당 100원 최대 5게임" />
 	<input type="submit" value="전송" />
 </form>
 <p>로또메인</p>
 </article>
</section>
<aside></aside>
 <%@ include file="../common/footer.jsp" %>  
 </body>
 <script src="../../js/lotto/main.js"></script>
 </html>