$(function(){
	$("#insertForm").validate({
		debug:true,
		submitHandler:function(form){
			form.submit();//表示采用手工方式提交
		},
		rules:{
			aid:{
				required:true
			},
			password:{
				required:true
			}
		}
	});
});