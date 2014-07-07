
function display(str){
	$("#prefer-result").html(str).show(200);
}

function prefer(){
	$.ajax({
		type:"post",
		url:"/Inception/Prefer.action",
		success:function(data){
			if( data == "success"){
				display("收藏成功");
				$("#prefer-img").attr("src", "/Inception/Home/images/pre.png");
				$("#prefer-img").click(unprefer);
			}else{
				display("收藏失败");
			}
			
		}
	})
}

function unprefer(){
	$.ajax({
		type:"post",
		url:"/Inception/UnPrefer.action",
		success:function(data){
			if( data == "success"){
				display("取消收藏成功");
				$("#prefer-img").attr("src", "/Inception/Home/images/unpre.png");
				$("#prefer-img").click(prefer);
			}else{
				display("取消收藏失败");
			}
			
		}
	})
}
