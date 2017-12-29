<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx }/resources/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="${ctx }/resources/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/jquery-easyui/jquery.easyui.min.js"></script>