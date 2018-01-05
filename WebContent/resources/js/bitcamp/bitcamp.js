function init(){
	var arr=['burgerking','kakao','bitcamp','sktelecom','lotto'];
	for(var i=0; i<arr.length; i++){
		document.querySelector('#' +arr[i]).addEventListener('click', 
				function(e){
					location.href="../"+this.id+"/main.jsp";
				},false);
		}
	document.querySelector('#attend_result').addEventListener('click',click,false);
}
function click() {
	alert('클릭');
	location.href="result.jsp";
	
}
window.addEventListener("load",init,false);
