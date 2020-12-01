<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 작성 페이지</title>
<style type="text/css">
	.writetable{
		margin: auto;
	}
	.containerwrite{
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="containerwrite">
		<form action="./write.do" method="post">
			<table border="1" class="writetable">
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