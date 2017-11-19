<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/9
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>编辑</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    String ad=request.getParameter("address");
    String au=request.getParameter("author");
    String id=request.getParameter("id");
    String ph=request.getParameter("photo");
%>
<script type="text/javascript" src="<%=path%>/layer-v3.0.3/layer/layer.js"></script>
<link href="<%=path%>/../layer-v3.0.3/layer/mobile/need/layui.css" rel="stylesheet" />
<link href="<%=path%>/../plugin/layui/css/layui.css" rel="stylesheet" />
<body>
<div id="man">
    <form action="/BlogServlet?act=up" method="post">
    作者：<input type="text" name="author" value="<%=au%>"><br/>
    <input type="hidden" name="id" value="<%=id%>">
    照片：<input type="text" name="photo" value="<%=ph%>"><br/>
    地址：<input type="text" name="address" value="<%=ad%>"><br/>
        <button class="layui-btn layui-btn-normal" type="submit">修改</button>
</form>
</div>


</body>
</html>
