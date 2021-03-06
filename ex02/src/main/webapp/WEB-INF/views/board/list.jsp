<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>    
<!DOCTYPE html>
<html>
<head>
    <!-- Custom fonts for this template -->
    <link href="../resources/css/all.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../resources/css/dataTables.bootstrap4.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-bordered" id="dataTable">
		<tr>
			<td>번호</td>		
			<td>제목</td>		
			<td>작성자</td>		
			<td>작성일</td>			
		</tr>
		<c:forEach items="${list}" var="board" >	
			<tr>
				<td>
					${board.bno}
				</td>
				<td>
					<a href="get?bno=${board.bno}">${board.title}[${board.replycnt}]</a>
				</td>
				<td>
					${board.writer}
				</td>
				<td>
					${board.regdate}
				</td>
			</tr>
		</c:forEach>		
	</table>
	
	<div class="pull-right">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button previous"><a href="list?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}">Previous</a></li>
			</c:if>	
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="paginate_button"><a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}">${num}</a></li>
			</c:forEach>									
			<c:if test="${pageMaker.next}">
				<li class="paginate_button next"><a href="list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}">Next</a></li>
			</c:if>
		</ul>
	</div>	
	
	<div>
		<form action="list" method="get">  
			<input type="text" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="text" name="amount" value="${pageMaker.cri.amount}">
			<select name="type">
				<option value="">--</option>
				<option value="TC">제목 or 내용</option>
				<option value="TW">제목 or 작성자</option>
				<option value="CW">내용 or 작성자</option>
				<option value="TCW">제목 or 내용 or 작성자</option>
			</select>
			<input type="text" name="keyword" >			
			<input type="submit" value="검색" >
		</form>
	</div>
</body>
</html>