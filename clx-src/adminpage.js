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
 * "강의 추가" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick6(e){
	var button = e.control;
	app.openDialog("addclasspage", {width : 800, height : 300}, function(dialog){
		dialog.ready(function(dialogApp){
			dialog.headerTitle = "수강 추가";
		});
	}).then(function(returnValue){
		alert(JSON.stringify(returnValue));
	});
}

/*
 * 그리드에서 context-value-change 이벤트 발생 시 호출.
 * 바인드컨텍스트를 가지고 있는 컨트롤에서 바인드컨텍스트를 이용해 값이 변경된 후에 발생하는 이벤트.
 */
function onGrd2ContextValueChange(e){
	var grd2 = e.control;
//	alert("변경")
//	var vcGrid = app.lookup("grd2");
//	
//	var code = vcGrid.getSelectedRow().getValue("code")
//    
//    app.lookup("changeclass").setValue("code", code);
//
//    app.lookup("selectcode").setValue("code", code);
//    app.lookup("check").send()
    
}

/*
 * 서브미션에서 submit-success 이벤트 발생 시 호출.
 * 통신이 성공하면 발생합니다.
 */
function onCheckSubmitSuccess(e){
	var check = e.control;
	
	var vcGrid = app.lookup("grd2");
	var code = vcGrid.getSelectedRow().getValue("code")
	var class_name = vcGrid.getSelectedRow().getValue("class_name")
	var teacher = vcGrid.getSelectedRow().getValue("teacher")
	var s_date = vcGrid.getSelectedRow().getValue("s_date")
	var e_date = vcGrid.getSelectedRow().getValue("e_date")
    
    app.lookup("changeclass").setValue("code", code);
	app.lookup("changeclass").setValue("class_name", class_name);
	app.lookup("changeclass").setValue("teacher", teacher);
	app.lookup("changeclass").setValue("s_date", s_date);
	app.lookup("changeclass").setValue("e_date", e_date);
	
	var check = app.lookup("codecheck").getValue("cknum")
    
    if(check = 0){
    app.lookup("addclass").send()	
    
    }else{
  	app.lookup("update").send()
    
    }
}

/*
 * "업데이트" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
//function onButtonClick(e){
//	var button = e.control;
//	
//	var vcGrid = app.lookup("grd2");	
//	var vnSelectedRowIdx = vcGrid.getSelectedRowIndex();
//    
//    var code = app.lookup("ipb2").value
//    var class_name = app.lookup("ipb3").value
//    var teacher = app.lookup("ipb4").value
//    
//	vcGrid.updateRow(vnSelectedRowIdx, {["class_name"]:class_name, ["teacher"]:teacher })
//	app.lookup("changeclass").setValue("code", code);
//	app.lookup("changeclass").setValue("class_name", class_name);
//	app.lookup("changeclass").setValue("teacher", teacher);
//	
//	app.lookup("update").send()
//}

/*
 * 그리드에서 update 이벤트 발생 시 호출.
 * Grid의 행 데이터가 수정되었을 때 이벤트.
 */
function onGrd2Update(e){
	var grd2 = e.control;
	var vcGrid = app.lookup("grd2");
	
	var code = vcGrid.getSelectedRow().getValue("code")
    
//    app.lookup("changeclass").setValue("code", code);

    app.lookup("selectcode").setValue("code", code);
    app.lookup("check").send()
}

/*
 * "강의 삭제" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick4(e){
	var button = e.control;
	var vcGrid = app.lookup("grd2");
	var code = vcGrid.getSelectedRow().getValue("code")
	app.lookup("selectcode").setValue("code", code);
	app.lookup("deleteclass").send()
	
}

/*
 * 서브미션에서 submit-done 이벤트 발생 시 호출.
 * 응답처리가 모두 종료되면 발생합니다.
 */
function onDeleteclassSubmitDone(e){
	var deleteclass = e.control;
	app.lookup("getclass").send();
	
	alert("삭제완료")
	app.lookup("grd2").redraw()
	
}

/*
 * "보기" 버튼에서 click 이벤트 발생 시 호출.
 * 사용자가 컨트롤을 클릭할 때 발생하는 이벤트.
 */
function onButtonClick(e){
	var button = e.control;
    var vcGrid = app.lookup("grd2");
	var code = vcGrid.getSelectedRow().getValue("code")
	
	app.openDialog("regiuser", {width : 800, height : 500}, function(dialog){
		dialog.ready(function(dialogApp){
			dialog.headerTitle = "수강 신청 인원 보기";
			dialog.initValue = {code: code};
		});
	}).then(function(returnValue){
		alert(JSON.stringify(returnValue));
	});
}
