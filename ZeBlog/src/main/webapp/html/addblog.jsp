<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/6
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Title</title>
</head>
<script type="text/javascript" src="<%=path%>/plugin/jquery-1.8.3.js"></script>
<script type="text/javascript">
    window.onload = function(){
        //得到所有的grid
        $grids = $(".grid");

        //
        $grids.each(function(){
            var sum = 0;
            //遍历它上面的人的总高度
            for(var i = $(this).index() - 3 ; i >= 0 ; i-=3){
                sum += $grids.eq(i).outerHeight() + 20;
            }
            console.log($(this).index());
            $(this).css({
                "top" : sum,
                "left" : ($(this).index() % 3) * 270
            })
        });
    }
</script>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-color: #ccc;
    }
    .waterfall{
        width: 790px;
        /*height: 1000px;*/
        /*border: 1px solid red;*/
        margin: 0 auto;
        position: relative;
    }
    #main {
        position: relative;
    }
    .grid{
        position: absolute;
        width: 230px;
        background-color: white;
        padding: 10px;
        border-radius: 15px;
    }
    .grid img{
        width: 230px;
    }
</style>
<body>
<div id="main">
    <c:forEach var="b" items="${bloglist}">
    <div class="grid">
        <img src="<%=path%>/images/${b.blogPhoto}" alt="${b.blogAuthor}">
        <a href="${b.blogAddress}">博客地址</a>
    </div>
    </c:forEach>
</div>
</body>
</html>
