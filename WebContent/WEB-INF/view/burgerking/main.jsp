<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %> 
 <%@ include file="../common/nav.jsp" %> 
 <div id="wrapper">
 <section>
 <article>
 	<header>
 		<hgroup>
 		<h1><mark>버거킹 주문 화면</mark></h1>
 		<h6>상품과 수량을 선택해주세요</h6>
 		</hgroup>	
 	</header>	
 </article>
 <article>
   	<form id="order_form" action="result.jsp" >
		 <table style="width : 300px; height:0px; margin: 0 auto" >
		 	<tr>
		 		<td>

		 	 <figure>  
		 	 	<img src="<%=application.getContextPath() %>/resources/img/hamburger.jpg" style="width : 200px; height:150px" alt=""  /> 
		 	<figcaption>
		 	 	<input type="checkbox" name="menu" value= "hamburger"/> 햄버거 : ￦5,500 <br />
		 	 	<input type="number" name="hamburger-count" style="width:30px" min="1" max="10" />개
		 	</figcaption>
		 	 </figure>
		 		</td>
		 		<td>
		 	<figure>
		 			<img src="<%=application.getContextPath() %>/resources/img/coffee.jpg" alt="" style="width : 200px; height:150px"  />    
		 	<figcaption>
		 		<input type="checkbox" name="menu" value= "coffee"/> 커피 : ￦900 <br />
				<input type="number" name="coffee-count" style="width:30px" min="1" max="10" />개
		 	</figcaption>
		 	</figure>
		 		</td>
		 		<td>
		 		<figure>
		 				<img src="<%=application.getContextPath() %>/resources/img/cokr.jpg" alt="" style="width : 200px; height:150px"  /> 
		 		<figcaption>
		 			<input type="checkbox" name="menu" value= "coke"/> 콜라 : ￦1,000 <br />
					<input type="number" name="coke-count" style="width:30px" min="1" max="10" />개
		 		</figcaption>
		 		</figure>
		 		</td>
		 	</tr >
		 	<tr>
		 		<td>
		 		<figure>
		 			<img src="<%=application.getContextPath() %>/resources/img/chip.jpg" alt="" style="width : 200px; height:150px"  /> 
		 		<figcaption>
		 			<input type="checkbox" name="menu" value= "chip"/> 감자칩 : ￦1,000 <br />
					<input type="number" name="chip-count" style="width:30px" min="1" max="10" />개
		 		</figcaption>
		 	</figure>
		 		</td>
		 		<td>
		 		<figure>
		 		<img src="<%=application.getContextPath() %>/resources/img/salads.jpg" alt="" style="width : 200px; height:150px"  /> 	
		 	<figcaption>
				<input type="checkbox" name="menu" value= "salad"/> 샐러드 : ￦1,200 <br />
				<input type="number" name="salad-count" style="width:30px" min="1" max="10" />개		 		
			</figcaption>
		 		</figure>
		 		</td>
		 		<td>
		 	<figure>
		 		<img src="<%=application.getContextPath() %>/resources/img/bagel.jpg" alt="" style="width : 200px; height:150px"  /> 
		 	<figcaption>
		 		<input type="checkbox" name="menu" value= "bagel"/> 베이글 : ￦2,000 <br />
				<input type="number" name="bagel-count" style="width:30px" min="1" max="10" />개
		 	</figcaption>
		 	</figure>
		 			
		 		</td>
		 	</tr>
		 		<tr>
		 	<td colspan="3">
		 		<input type="radio" name="place" value="매장식사" checked="checked"  /> 매장식사
		 		<input type="radio" name="place" value="테이크아웃"  /> 테이크아웃
		 	</td>
		 		</tr>
		 	<tr>
			 	<td colspan="3">
			<input type="hidden" name="hamburger" value="5500" />		
			<input type="hidden" name="coke" value="1000" />		
			<input type="hidden" name="chip" value="1000" />		
			<input type="hidden" name="coffee" value="900" />
			<input type="hidden" name="bagel" value="2000" />
			<input type="hidden" name="salad" value="1500" />
			
			<input id="order_btn" type="button" value="전송" style="widht : 200px;margin-right : 20px"  />  
			 	</td>
		 	</tr>
		 </table>
		</form>
		</article>
	</section>
	<aside></aside>	
	</div>
<%@ include file="../common/footer.jsp" %>  
</body>
<script src="../../js/burgerking/main.js"></script>
</html>
	