<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글입력 페이지</title>
<style type="text/css">
	.replytable{
		margin: auto;
	}
	.containerreply{
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="containerreply">
		<form action="./reply.do" method="post">
		<input type="hidden" name="seq" value="${seq}">
			<table border="1" class="replytable">
				<tr>
					<th>작성자</th>
					<td><input type="text" required="required"
						placeholder="아이디를 입력하세요" name="id"></td>
				</tr>
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td><input type="text" required="required"
						placeholder="제목을 입력하세요" name="title"></td>
				</tr>
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td><textarea rows="10" cols="50" placeholder="내용을 입력하세요"
							required="required" name="content"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="작성완료"> <input type="button"
				value="돌아가기" onclick="location.href='javascript:history.back(-1)'">
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>