<!--

 @Name：不落阁后台模板源码
 @Author：Absolutely
 @Site：http://www.lyblogs.cn

 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline pm-login-input">
            <input type="text" name="account" lay-verify="account" placeholder="请输入账号" value="lyblogscn" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline pm-login-input">
            <input type="password" name="password" lay-verify="passWord" placeholder="请输入密码" value="111111" autocomplete="off" class="layui-input">
        </div>
    </div>
   <%-- <div class="layui-form-item">
        <label class="layui-form-label">人机验证</label>
        <div class="layui-input-block">
            <input type="password" name="password" lay-verify="passWord" placeholder="人机验证，百度螺丝帽" value="" autocomplete="off" class="layui-input">
        </div>
    </div>--%>
    <div class="layui-form-item" style="margin-top:25px;margin-bottom:0;">
        <div class="layui-input-block">
          <button class="layui-btn" style="width:230px;" lay-submit="" lay-filter="login" type="submit">立即登录</button>
           <%-- <input  type="submit" value="立即登录"></input>--%>

        </div>
    </div>
</form>