<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form>
		<div class="form-group">
  			<label for="nickname">닉네임:</label>
  			<input type="text" class="form-control" id="nickname">
		</div>
		<div class="form-group">
  			<label for="password">비밀번호:</label>
  			<input type="password" class="form-control" id="password">
		</div>
		<div class="form-group">
  			<label for="title">제목:</label>
  			<input type="text" class="form-control" id="title">
		</div>
		<div class="form-group">
  			<textarea class="form-control" rows="5" id="content"></textarea>
		</div>
		<button class="btn btn-primary" style='width:100px;'>작성</button>
	</form>
</body>
</html>