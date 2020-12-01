<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<style type="text/css">
	.detailtable{
		margin: auto;
	}
	.containerdetail{
		text-align: center;
		margin: 30px auto 5px auto;
	}
.btn{
		margin:5px auto 10px auto;
	}
</style>
</head>
<script type="text/javascript">
	function deleteOne(){
		if(confirm("정말 삭제하시겠읍니까?")){
			return location.href='./delete.do?seq=${dto.seq}'			
		}
	}
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="containerdetail">
			<table border="1" class="detailtable">
				<tr>
					<th>작성자</th>
					<td>${dto.id}</td>
<%-- 					<td><input type="text" readonly="readonly" name="id" value="${dto.id}"></td> --%>
				</tr>
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td>${dto.title}</td>
<%-- 					<td><input type="text" required="required" name="title" value="${dto.title}"></td> --%>
				</tr>
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td>${dto.content}
<%-- 					<textarea rows="10" cols="50" name="content" >${dto.content}</textarea> --%>
					</td>
				</tr>
				<tr>
					<th>게시일</th>
					<td>${dto.regdate}</td>
<%-- 					<td><input type="text" readonly="readonly" name="regdate" value="${dto.regdate}"></td> --%>
				</tr>
			</table>
			<input type="button" class="btn" value="수정" onclick="location.href='./modifyform.do?seq=${dto.seq}'"/>
			<input type="button" class="btn" value="삭제" onclick="deleteOne()"/>
			<input type="button" class="btn" value="답글" onclick="location.href='./replyform.do?seq=${dto.seq}'"/>
			<input type="button" class="btn" value="돌아가기" onclick="location.href='javascript:history.back(-1)'">
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>