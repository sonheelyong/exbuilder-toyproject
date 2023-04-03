/************************************************
 * regiuser2.js
 * Created at 2023. 3. 31. 오전 10:58:11.
 *
 * @author user
 ************************************************/

/*
 * 루트 컨테이너에서 load 이벤트 발생 시 호출.
 * 앱이 최초 구성된후 최초 랜더링 직후에 발생하는 이벤트 입니다.
 */


function onBodyLoad(e){
	var initValue = app.getHost().initValue;
	var code = initValue.code

	app.lookup("code").setValue("code", code);
	app.lookup("getcodeclass").send()
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onGetcodeclassSubmitSuccess2(e){
	var getcodeclass = e.control;
	app.lookup("grd1").redraw()
	app.lookup("out1").redraw()
	app.lookup("out2").redraw()
	app.lookup("out3").redraw()
	app.lookup("out4").redraw()
}

/*
 * "수강 취소" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
	
	
	var vcGrid = app.lookup("grd1");
	var regi_no = vcGrid.getSelectedRow().getValue("regi_no")
	var user_id = vcGrid.getSelectedRow().getValue("user_id")
	
	if(confirm(user_id+"님의 강의신청을 취소하시겠습니까?") == true){
		app.lookup("regi_no").setValue("regi_no", regi_no);
	    app.lookup("deleteregi_no").send()
	}else{}
		
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onDeleteregi_noSubmitSuccess(e){
	var deleteregi_no = e.control;
	alert("강의 신청 취소가 완료되었습니다")
	var initValue = app.getHost().initValue;
	var code = initValue.code

	app.lookup("code").setValue("code", code);
	app.lookup("getcodeclass").send()
}
