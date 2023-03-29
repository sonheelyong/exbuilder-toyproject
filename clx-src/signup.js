/************************************************
 * login.js
 * Created at 2023. 3. 24. 오후 5:32:26.
 *
 * @author user
 ************************************************/
var idc = 0

/*
 * "중복확인" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	var ipb1 = app.lookup("ipb1").value;
	if(ipb1 == ""){
		alert("아이디를 입력해주세요.")
	}else{
	app.lookup("idcheck").send();}
}

/*
 * "회원가입" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick3(e){
	var button = e.control;
	var ipb1 = app.lookup("ipb1").value;
	var ipb2 = app.lookup("ipb2").value;
	var ipb3 = app.lookup("ipb3").value;
	var ipb4 = app.lookup("ipb4").value;
	
	if(ipb3 != ipb4){alert("비밀번호 확인이 일치하지 않습니다.")}
	else if(ipb1 == ""){alert("아이디를 입력해주세요.")}
	else if(ipb2 == ""){alert("이름을 입력해주세요.")}
	else if(ipb3 == ""){alert("비밀번호를 입력해주세요.")}
	else if(idc == 0)  {alert("아이디 중복확인이 필요합니다.")}
	else{
	app.lookup("signup").send();
	alert("회원가입 완료")
	var link = '/ui/index.clx';
	location.href=link;
	}
}

/*
 * "ddd" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick5(e){
	var button = e.control;
	app.lookup("sms3").send();

}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onSms3SubmitSuccess(e){
	var sms3 = e.control;
	app.lookup("ipb5").redraw();
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onIdcheckSubmitSuccess(e){
	var idcheck = e.control;
	var check = app.lookup("dm2").getValue("idcheck")
	if(check == 0){
		alert("사용가능한 아이디 입니다.")
		idc = 1
	}else{
		alert("이미 사용중인 아이디 입니다.")
		idc = 0
	}
}
