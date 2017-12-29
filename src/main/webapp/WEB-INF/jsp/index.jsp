<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB-INF/index</title>
</head>
<body>
	<h5>欢迎:<shiro:user><shiro:principal /></shiro:user> | <a href="${ctx }/logout">退出</a></h5>
	
	${currentUser.username }
	
	<shiro:hasRole name="admin">
		admin display <br/>
	</shiro:hasRole>
	
	<shiro:hasPermission name="user:create">
		user:create permission display <br/>
	</shiro:hasPermission>
	
	<shiro:authenticated>
		authenticated display <br/>
	</shiro:authenticated>
	
	
	<shiro:guest>
		guest display <br/>
	</shiro:guest>
	
	<shiro:hasAnyRoles name="admin">
		any roles admin display <br/>
	</shiro:hasAnyRoles>
	
	<shiro:hasAnyRoles name="temp">
		any roles temp display <br/>
	</shiro:hasAnyRoles>
	
	<shiro:lacksPermission name="user:create">
		lacksPermission admin display <br/>
	</shiro:lacksPermission>
	
</body>
</html>