<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정페이지</title>
<style type="text/css">
	.modifytable{
		margin: auto;
	}
	.containermodify{
		text-align: center;
		margin: 30px auto 5px auto;
	}
.btn{
		margin:5px auto 10px auto;
	}
</style>
</head>
<script type="text/javascript">
	function valueChange(){
		document.getElementById("content").value="";
	}
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="containermodify">
	<form action="./modify.do" method="post">
	<input type="hidden" name="seq" value="${dto.seq}"> 
			<table border="1" class="modifytable">
				<tr>
					<th>작성자</th>
					<td><input type="text" readonly="readonly" name="id" value="${dto.id}"></td>
				</tr>
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td><input type="text" required="required" name="title" value="${dto.title}"></td>
				</tr>
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td>
						<textarea rows="10" cols="50" id="content" name="content" onclick="valueChange()">${dto.content}</textarea>
					</td>
				</tr>
				<tr>
					<th>게시일</th>
					<td><input type="text" readonly="readonly" name="regdate" value="${dto.regdate}"></td>
				</tr>
			</table>
			<input type="submit" class="btn" value="수정완료"/>
			<input type="button" class="btn" value="돌아가기" onclick="location.href='javascript:history.back(-1)'">
			</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>