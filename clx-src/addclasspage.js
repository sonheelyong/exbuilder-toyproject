/************************************************
 * addclasspage.js
 * Created at 2023. 3. 31. 오전 9:09:35.
 *
 * @author user
 ************************************************/

/*
 * "강의 추가" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	
	var s_date = Number(app.lookup("dti1").value)
	var e_date = Number(app.lookup("dti2").value)
	
	if (s_date > e_date){
		alert("종료일이 시작일 보다 빠를수 없습니다.")
	}else{
	app.lookup("addclasssub").send()
	alert("수강 추가 완료")
	}
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onAddclasssubSubmitSuccess(e){
	var addclasssub = e.control;
	
	app.lookup("ipb1").clear();
	app.lookup("ipb2").clear();
	app.lookup("dti1").clear();
	app.lookup("dti2").clear();
}
