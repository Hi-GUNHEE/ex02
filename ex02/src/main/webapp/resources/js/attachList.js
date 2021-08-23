/**
 * 
 */

$(document).ready(function(){
	var bno =  $("#bno").val();	
	$.getJSON("getAttachList", {bno:bno}, function(arr){
		console.log(arr);
		var str = "";
		$(arr).each(function(i, attach){
			//	첨부파일이 이미지
			if(attach.filetype){
				var fileCallPath = encodeURIComponent(attach.uploadpath+"/s_"+attach.uuid+"_"+ attach.filename);
				str += "<li data-path='"+attach.uploadpath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.filename+"'" +
						"data-type='"+attach.filetype+"'><div>";
				str += "<img src='/display?filename="+fileCallPath+"'>"
				str += "</div></li>";					
			//	이미지가 아닐경우	
			}else{
				str += "<li data-path='"+attach.uploadpath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.filename+"'" +
						"data-type='"+attach.filetype+"'><div>";
				str += "<span>"+attach.filename+"</span><br>"
				str += "<img src='/display?filename="+fileCallPath+"'>"
				str += "</div></li>";
			}			
		})	//	each
		$(".uploadResult ul").html(str);
	})
})