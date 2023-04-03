/************************************************
 * regiList.js
 * Created at 2023. 4. 2. 오후 11:09:42.
 *
 * @author User
 ************************************************/

/*
 * 루트 컨테이너에서 load 이벤트 발생 시 호출.
 * 앱이 최초 구성된후 최초 랜더링 직후에 발생하는 이벤트 입니다.
 */
function onBodyLoad(e){
	app.lookup("getRegiList").send()
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onGetRegiListSubmitSuccess(e){
	var getRegiList = e.control;
	app.lookup("grd1").redraw()
}

/*
 * "신청 취소" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	var vcGrid = app.lookup("grd1");
	var code = vcGrid.getSelectedRow().getValue("code")
	var teacher = vcGrid.getSelectedRow().getValue("teacher")
	var class_name = vcGrid.getSelectedRow().getValue("class_name")
	
	
	
	if(confirm("강의명:"+class_name+",강사명:"+teacher+"\n수강신청을 취소 하시겠습니까?") == true){
		app.lookup("selectcode").setValue("code", code);
		app.lookup("cancle").send()
		}else{}
	
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onCancleSubmitSuccess(e){
	var cancle = e.control;
	alert("수강 신청 취소가 완료되었습니다.")
	app.lookup("getRegiList").send()
}
