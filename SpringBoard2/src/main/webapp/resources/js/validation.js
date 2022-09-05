	/*유효성 검사 조건
	  1. 아이디는 영문자, 숫자 포함 4-12자 이하로 입력해주세요 
	  2. 비밀번호는 영문자, 숫자, 특수문자 포함 8~12자로 입력해주세요
	  3. 비밀번호를 동일하게 입력하세요		  
	  4. 이름을 입력해주세요
	*/
 function checkForm(){
 	let form = document.regForm;     //폼 이름
	let id = form.userid.value;    //아이디 입력값
	let pwd1 = form.userpw.value;    //비밀번호 입력값
	let pwd2 = form.userpw_confirm.value; //비밀번호 확인 입력값
	let name = form.username.value;      //이름 입력값
	
	//정규식 변수 할당
	let regExpId = /^[a-zA-Z0-9]*$/ //영문자, 숫자만(^-시작, *-반복)
	let regExpPwd1 = /[a-zA-Z0-9]/  //영문자, 숫자
	let regExpPwd2 = /[~!@#$%^&*()_+/]/  //특수문자
	let regExpPwd3 = /[ㄱ-ㅎㅏ-ㅣ가-힣]/  //한글
	
	if(id.length < 4 || id.length > 12 || !regExpId.test(id)){
		alert("아이디는 영문자, 숫자 포함 4-12자 이하로 입력해주세요 ");
		form.userid.focus();
		form.userid.select();
		return false;
	}else if(pwd1.length < 8 || pwd1.length > 12 ||
			!regExpPwd1.test(pwd1) || !regExpPwd2.test(pwd1) ||
			regExpPwd3.test(pwd1)){
		alert("비밀번호는 영문자, 숫자, 특수문자 포함 8-12자 이하로 입력해주세요 ");
		form.userpw.focus();
		form.userpw.select();
		return false;
	}else if(pwd1 != pwd2){
		alert("비밀번호를 동일하게 입력해주세요");
		form.userpw_confirm.focus();
		form.userpw_confirm.select();
		return false;
	}else if(name == ""){
		alert("이름을 입력해주세요");
		form.username.focus();
		return false;
	}
	
	
}