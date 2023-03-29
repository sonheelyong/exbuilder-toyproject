/*
 * App URI: adminpage
 * Source Location: adminpage.clx
 *
 * This file was generated by eXbuilder6 compiler, Don't edit manually.
 */
(function() {
	var app = new cpr.core.App("adminpage", { 
		onPrepare: function(loader) {
		},
		onCreate: function(/* cpr.core.AppInstance */ app, exports) {
			var linker = {};
			// Start - User Script
			/************************************************
			 * adminpage.js
			 * Created at 2023. 3. 28. 오후 3:09:34.
			 *
			 * @author user
			 ************************************************/;
			// End - User Script
			
			// Header
			app.supportMedia("all and (min-width: 1024px)", "default");
			app.supportMedia("all and (min-width: 500px) and (max-width: 1023px)", "tablet");
			app.supportMedia("all and (max-width: 499px)", "mobile");
			
			// Configure root container
			var container = app.getContainer();
			container.style.css({
				"width" : "100%",
				"height" : "100%"
			});
			
			// Layout
			var xYLayout_1 = new cpr.controls.layouts.XYLayout();
			container.setLayout(xYLayout_1);
			
			// UI Configuration
			var output_1 = new cpr.controls.Output();
			output_1.value = "수강 관리 페이지 (관리자용)";
			output_1.style.css({
				"font-size" : "40px",
				"text-align" : "center"
			});
			container.addChild(output_1, {
				"top": "10px",
				"width": "374px",
				"height": "110px",
				"left": "calc(50% - 187px)"
			});
		}
	});
	app.title = "adminpage";
	cpr.core.Platform.INSTANCE.register(app);
})();
