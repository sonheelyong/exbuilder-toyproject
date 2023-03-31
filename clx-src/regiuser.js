/************************************************
 * regiuser2.js
 * Created at 2023. 3. 31. 오전 10:58:11.
 *
 * @author user
 ************************************************/

/*
 * 루트 컨테이너에서 init 이벤트 발생 시 호출.
 * 앱이 최초 구성될 때 발생하는 이벤트 입니다.
 */
	function onBodyInit(e){
	var initValue = app.getHost().initValue;
	var code = initValue.code

	app.lookup("code").setValue("code", code);
	app.lookup("getcoderegi").send()

}
