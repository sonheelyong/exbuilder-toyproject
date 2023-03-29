/************************************************
 * index.js
 * Created at 2023. 3. 24. 오후 5:10:52.
 *
 * @author user
 ************************************************/

/*
 * "회원가입" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	var link = '/ui/signup.clx';
	location.href=link;
}

/*
 * "로그인" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick2(e){
	var button = e.control;
	app.lookup("loginsub").send()
	alert("로그인123")
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
  function onLoginsubSubmitSuccess(e){
 	var loginsub = e.control;
    var id = app.lookup("user").getValue("user_id")
    var role = app.lookup("user").getValue("user_role")
	if(id == ""){
		alert("아이디와 비밀번호를 확인해주세요.")
	}else{
		if(role == '0'){
		var link = '/ui/main.clx';
	    location.href=link;}
	    else{
	    	var link = '/ui/adminpage.clx';
	        location.href=link;}
	    }
	}
  

