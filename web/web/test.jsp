<%@ page contentType="text/html;charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>��֤������ҳ��</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<body>
	<form method=post action="check.jsp">
		<table>
			<tr>
				<td align=left>ϵͳ��������֤�룺</td>
				<td><img id="img" border=0 src=""></td>
				<td><a href="" onclick="function x() {
				 var url='vc_image.jsp';
                    $('#img').attr('src',url+'?t='+Math.random());
				}">��һ��</a></td>
			</tr>
			<tr>
				<td align=left>�����������֤�룺</td>
				<td><input type=text name=rand maxlength=4 value=""></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=submit value="�ύ���">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script>
	var url="vc_image.jsp";
	$("#img").attr("src",url+"?t="+Math.random());
	</script>
	
</body>
</html>