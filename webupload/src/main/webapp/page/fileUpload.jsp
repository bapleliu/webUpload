<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
<h2>文件上传实例</h2>

<form action="/fileUpload.do" method="post" enctype="multipart/form-data">
	选择文件:<input type="file" name="file">
	<input type="submit" value="提交"> 
</form>

</body>
</html>