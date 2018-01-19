<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>		
<nav id="nav">
		<ul>
			<li>
			<a id="burgerking" href="">버거킹</a></li>
			<li>
			<a id="kakao" href="${ctx}/kakao.do?cmd=kakao&dir=kakao&page=main">카카오뱅크</a></li>
			<li>
			<a id="bitcamp" href="#" >비트캠프</a></li>
			<li>
			<a id="sktelecom"href="${ctx}/phone.do?cmd=phone&dir=sktelecom&page=main" >에스케이텔레콤</a></li>
			<li>
			<a  id="lotto" href="#" >로또</a></li>
			<li>
			<a id=""href="#">마이페이지</a></li>
			<li>
			<a id="logout"href="${ctx}/user.do?cmd=logout">로그아웃</a></li>
		</ul>
</nav>	
<script>
document.querySelector('#kakao').addEventListener('click',
		function(){
	location.href="${ctx}/kakao.do?cmd=move&page=main";
},false);
</script>
			