/************************************************
 * main.js
 * Created at 2023. 3. 27. 오전 10:37:29.
 *
 * @author user
 ************************************************/

/*
 * 루트 컨테이너에서 init 이벤트 발생 시 호출.
 * 앱이 최초 구성될 때 발생하는 이벤트 입니다.
 */
function onBodyInit(e){
	app.lookup("getclass").send();
	app.lookup("getuser").send();
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onGetclassSubmitSuccess(e){
	var getclass = e.control;
	app.lookup("grd2").redraw();
}

/*
 * "조회" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick2(e){
	var button = e.control;
	app.lookup("serchclass").send()
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onGetuserSubmitSuccess(e){
	var getuser = e.control;
	app.lookup("output1").redraw()
}

/*
 * "로그아웃" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick3(e){
	var button = e.control;
	app.lookup("logout").send()
	var link = '/ui/index.clx';
	location.href=link;
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onSerchclassSubmitSuccess(e){
	var serchclass = e.control;
	app.lookup("grd2").redraw()
}

/*
 * "강의신청" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick4(e){
	var button = e.control;
//	var vcGrid = app.lookup("grd1");
//	var vnSelectedRowIdx = vcGrid.getSelectedRowIndex();
	alert("dd")
//	alert(vnSelectedRowIdx);
	
}

/*
 * "수강신청" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick5(e){
	var button = e.control;
	var vcGrid = app.lookup("grd2");
	var index = vcGrid.getSelectedRowIndex();
	var vnSelectedRowIdx = vcGrid.dataSet.getOriginalValue(index, "code");
	app.lookup("selectcode").setValue("code", vnSelectedRowIdx);
	app.lookup("regiclass").send()
	
}
