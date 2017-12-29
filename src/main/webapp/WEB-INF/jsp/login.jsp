<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
		<style type="text/css">
			.panel-title{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div id="loginFormDiv" class="easyui-dialog"  data-options="width:'350',height:240,title:'Login',modal:'true',closable:false">
			<span style="color: red;">${error }</span>
			<form action="${ctx}/login" id="loginForm" method="post">
				<dl>
					<dd style="margin:20px 70px;"><input id="username" name="username" style="width: 200px; height: 28px;" class="easyui-textbox" data-options="iconCls : 'icon-man',prompt:'username'"  /></dd> 
					<dd style="margin:20px 70px;"><input id="password" name="password" style="width: 200px; height: 28px;" class="easyui-textbox" data-options="iconCls : 'icon-lock',prompt:'password',type:'password'" /></dd>
					<dd style="margin:20px 70px;"><input id="captcha" name="captcha" style="width: 80px; height: 28px;" class="easyui-textbox" /><span style="display: inline-block;height:26px;width:70px;vertical-align: middle;margin-left:10px;"><img src="${ctx}/captcha" onclick="this.src='${ctx}/captcha?d='+new Date().getTime()" style="height:26px;width:70px;" /></span></dd>
					<!-- <dd style="margin:20px 70px;">Remember Me<input type="checkbox" name="rememberMe"/></dd>  -->
					<dt style="margin:20px 70px;"><a id="submitForm" href="javascript:;" class="easyui-linkbutton" style="width: 200px; height: 28px;" data-options="iconCls:'icon-ok'">Login</a></dt>				
				</dl>
			</form>
		</div>
		<script type="text/javascript">
		$(function(){   
		    $('#submitForm').bind('click', function(){   
		        $('#loginForm').submit();  
		    });   
		}); 
		</script>
	</body>
</html>



