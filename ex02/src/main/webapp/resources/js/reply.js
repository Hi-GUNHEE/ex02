$(document).ready(function(){          

	//	get.jsp에 있는 bno값 가져오기
	var bno = $("#bno").val();
	
	showList();
	
	function showList(){
		replyService.getList(
				{bno:bno},
				function(list){
					var str="";
					for(var i=0 ; i<list.length ; i++){					
						str += "<li>"+list[i].replyer+"</li>"
						str += "<li><textarea rows='3' cols='30' id='modreply"+list[i].rno+"'>"+list[i].reply+"</textarea></li>"
						str += "<li>"+list[i].replydate+"</li>"
						str += "<li><button class='replymod' id='replymod' data-rno='"+list[i].rno+"'>댓글수정</button><button class='replydel' data-rno='"+list[i].rno+"'>댓글삭제</button></li>"
					}
					$("#replyList").html(str);
				}			
		);
	}
	
	//	댓글 버튼
	$("#replyadd").on("click", function(e){		
		//	get.jsp에 있는 reply값 가져오기
		var reply = $("#reply").val();
		//	get.jsp에 있는 replyer값 가져오기
				
		replyService.add(				
				{reply:reply, replyer:"bbb", bno:bno},
				function(result){
					alert("결과 : "+result);
					showList();
				}
		);
		
	});	
	
	//	수정 버튼
	$("#replyList").on("click",".replymod",function(e){
		
		var rno = $(this).data("rno");
		//	get.jsp에 있는 reply값 가져오기
		var reply = $("#modreply"+rno).val();
		
		replyService.update(
			{reply:reply, rno:rno},
			function(result){
				alert("결과 : "+result);
				showList();
			}
		);
	});
	
	//	삭제 버튼
	$("#replyList").on("click",".replydel",function(e){
		var rno = $(this).data("rno");	
		replyService.remove(
			rno,
			function(result){
				alert("결과 : "+result);
				showList();
			}	
		);
	});
	
})	

var replyService = (function(){
	//	댓글 쓰기
	function add(reply, callback, error){
		//	alert("123");
		console.log("add reply");
		$.ajax({
			type: "post",
			url: "/replies/new",	// ReplyController 연결부분
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}	
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}	
			}
		})
	}	// add함수 끝
	
	//	댓글 목록 리스트
	function getList(param,callback,error){
		var bno = param.bno;
		
		$.getJSON("/replies/page/"+bno+".json",
			function(data){
				if(callback){
					callback(data);
				}	
			}).fail(function(xhr, status, er){
				if(error){
					error(er);
				}	
		});		
	}	//	getList함수 끝
	
	//	댓글 수정
	function update(reply, callback, error){
		$.ajax({
			type:"put",
			url:"/replies/"+reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback){
					callback(result);
					}	
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}	
			}
		})
	}  //	update함수 끝 
	
	//	댓글 삭제
	function remove(rno, callback, error){
		$.ajax({
			type:"delete",
			url:"/replies/"+rno,			
			success: function(result, status, xhr){
				if(callback){
					callback(result);
					}	
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}	
			}
		})
	} //	delete함수 끝
	
	return{
		add:add,
		getList:getList,
		update:update,
		remove:remove
	}
})();
