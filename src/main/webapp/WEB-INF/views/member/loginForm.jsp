<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="result" value="${param.result }" />
<%
   request.setCharacterEncoding("UTF-8");
%>  


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���â</title>

<c:choose>
	<c:when test="${result=='loginFailed' }">
	  <script>
	    window.onload=function(){
	      alert("���̵� ��й�ȣ�� Ʋ���ϴ�.�ٽ� �α��� �ϼ���!");
	    }
	  </script>
	</c:when>
</c:choose> 

</head>
<body>
<form name="frmLogin" method="post"  action="${contextPath}/member/login.do">
   <table border="1"  width="80%" align="center" >
      <tr align="center">
         <td>���̵�</td>
         <td>��й�ȣ</td>
      </tr>
      <tr align="center">
         <td>
	    <input type="text" name="id" value="" size="20">
	 </td>
         <td>
	    <input type="password" name="pwd" value="" size="20">
	 </td>
      </tr>
      <tr align="center">
         <td colspan="2">
            <input type="submit" value="�α���" > 
            <input type="reset"  value="�ٽ��Է�" > 
         </td>
      </tr>
   </table>
</form>
</body>
</html>