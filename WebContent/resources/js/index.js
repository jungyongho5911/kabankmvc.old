function init() {
	var goAdminLink = document.querySelector('#go_admin_link');
	var goJoinLink = document.querySelector('#go_join_link');
	var indexLoginBtn = document.querySelector('#index_login_btn');
	goAdminLink.addEventListener("click",goAdmin,false);
	goJoinLink.addEventListener("click",goJoin,false);
	indexLoginBtn.addEventListener("click",indexLogin,false);
}
function indexLogin(e) {
	var loginId = document.querySelector('#index_input_id').value;
	var joinId = sessionStorage.getItem('id');
	var loginPass= document.querySelector('#index_input_pass').value;
	var joinPass = sessionStorage.getItem('pass');
	if(!(loginId === joinId) && (loginPass === joinPass)){
		e.preventDefault();
		alert('입력하신'+loginId+('id 는 틀립니다'));
	}
	else if(!(loginPass === joinPass) && (loginId === joinId)){
		e.preventDefault();
		alert('입력하신'+loginPass+(' pass 는 틀립니다'));
	}
	else if(!(loginPass === joinPass) && !(loginId === joinId)){
		e.preventDefault();
		alert('아이디와 패스워드를 확인하세요');
	}
}
function goAdmin(){
	 var admin = confirm('관리자?');
    if(admin){
          alert('안녕하세요 관리자님');
          location.href="admin/main.jsp";
    }else{
          alert('관리자만 접근가능 합니다');
    }
}
function goJoin() {
	location.href="user/join_form.jsp";
}
window.addEventListener("load",init,false);