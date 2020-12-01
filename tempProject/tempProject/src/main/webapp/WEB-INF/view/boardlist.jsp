<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>준이의 답변형게시판 전체글보기</title>
<style type="text/css">
table {
	margin: 30px auto 5px auto;
}
.btn{
		margin:5px auto 10px auto;
	}
</style>
</head>
<script type="text/javascript">
	var chk = document.getElementsByName("check");
	function checkDel(){
		var cnt = 0;
		for (var i = 0; i < chk.length; i++) {
			if(chk[i].checked){
				cnt++
			}
		}
		if(cnt>0){
			return confirm("정말 삭제하시겠습니까?");
		}else{
			location.href="./error.jsp";
		}
	}
	var check =  document.getElementsByName("check");
	
	function checkAll(bool){
		for (var i = 0; i < check.length; i++) {
			check[i].checked = bool;			
		}
	}
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center;">
		<form action="./multidel.do" method="post" onsubmit="return checkDel()">
			<table border="1">
				<tr>
					<th><input type="checkbox" id = "Allcheck" onclick="checkAll(this.checked)"></th>
					<th>번&nbsp;&nbsp;&nbsp;호</th>
					<th>아이디</th>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<th>게시일</th>
				</tr>
				<c:forEach var="L" items="${lists}" varStatus="vs" begin="0" end="5">
					<tr>
						<td><input type="checkbox" name="check" value="${L.seq}" onclick="checkOne(this.checked)"></td>
						<td>${L.seq}</td>
						<td>${L.id}</td>
						<td><a href="./detailboard.do?seq=${L.seq}" style="text-decoration: none;">${L.title}</a></td>
						<td>${L.regdate}</td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align: center; margin: 5px auto;" >
				<c:choose>
					<c:when test="${PDto.startPage ne 1}">
						<a href="./boardlist.do?page=1" style="text-decoration: none;">◀◀</a>
					</c:when>
					<c:otherwise>
			◁◁
		</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${PDto.startPage ne 1}">
						<a href="./boardlist.do?page=${PDto.startPage - PDto.countPage}"
							style="text-decoration: none;">◀</a>
					</c:when>
					<c:otherwise>
			◁
		</c:otherwise>
				</c:choose>
				<c:forEach var="p" begin="${PDto.startPage}" end="${PDto.endPage}">
					<c:choose>
						<c:when test="${p <= PDto.totalPage}">
							<a href="./boardlist.do?page=${p}" style="text-decoration: none;">${p}</a>
						</c:when>
						<c:otherwise>
				♥
			</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${PDto.endPage >= PDto.totalPage}">
			▷
		</c:when>
					<c:otherwise>
						<a href="./boardlist.do?page=${PDto.startPage + PDto.countPage}"
							style="text-decoration: none;">▶</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${PDto.endPage >= PDto.totalPage}">
			▷▷
		</c:when>
					<c:otherwise>
						<a href="./boardlist.do?page=${PDto.totalPage}"
							style="text-decoration: none;">▶▶</a>
					</c:otherwise>
				</c:choose>
			</div>
			<input class="btn" type="button" value="새글작성" onclick="location.href='./writeform.do'"> 
			<input class="btn" type="submit" value="다중삭제"> 
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>