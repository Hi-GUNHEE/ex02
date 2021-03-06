<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Jquery연결 -->
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Javascript 파일 연결 -->
<script src="../resources/js/reply.js"></script>
<script src="../resources/js/attachList.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<table>
		<tr>
			<td>번호</td>
			<td>
				<input type="text" name="bno" id="bno" value="${board.bno}" readonly>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="title" value="${board.title}">
			</td>
		</tr>		
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="20"  name="content" >${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				${board.writer}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정"  formaction="modify">
				<input type="submit" value="삭제"  formaction="remove">
			</td>
		</tr>
	</table>
</form>
<div class="uploadResult">
	<ul>
		첨부파일 
	</ul>
</div>	
<div>
	<ul id="replyList">
	</ul>
</div>
<div>
	<textarea rows="3" cols="30" id="reply"></textarea>
	<button id="replyadd">댓글</button>		
</div>	
</body>
</html>