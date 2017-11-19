<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/6
  Time: 15:25
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
    <title>博客列表</title>
</head>
<script type="text/javascript" src="<%=path%>/plugin/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=path%>/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript" src="<%=path%>/plugin/layui/css/layui.css"></script>
<script type="text/javascript">
   <c:forEach var="b" items="${bloglist}">
    $(window).on("load",function () {
     waterfall();
        var dataInt = { "data":[{"src":"${b.blogPhoto}"}]}

        //模拟json数据;
        $(window).on("scroll",function () {
            if(checkScrollSlide){
                $.each(dataInt.data,function (key,value) {
                    var oBox=$("<div>").addClass("box").appendTo($("#main"));
                    //jQuery支持连缀,隐式迭代;
                    var oPic=$("<div>").addClass('pic').appendTo($(oBox));
                    $("<img>").attr("src","images/"+$(value).attr("src")).appendTo(oPic);

                });
                waterfall();
            }
        });
    });
    </c:forEach>
    //流式布局主函数;
    function waterfall () {
        var $boxs=$("#main>div");
        //获取#main元素下的直接子元素div.box;
        //获取每一列的宽度;
        var w=$boxs.eq(0).outerWidth();
        //outerWidth()获取包含padding和border在内的宽度;
        //var w=$boxs.eq(0).width();
        //width()只能获取给元素定义的宽度;
        var cols=Math.floor($(window).width()/w);
        //获取多少列;
        $("#main").width(w*cols).css("margin","0 auto");
        //设置#main元素的宽度和居中样式;
        var hArr=[];
        //每一列高度的集合;
        $boxs.each(function (index,value) {
            //遍历每一个box元素;
            //为了找到之前所有元素的最低点,然后将本元素设置到最低点之下;
            var h=$boxs.eq(index).outerHeight();
            //每一个box元素的高,
            if (index<cols) {
                hArr[index]=h;
                //确定每列第一个元素的高度;
            } else{
                var minH=Math.min.apply(null,hArr);
                //得出列高数组中的最小高度;
                var minHIndex=$.inArray(minH,hArr);
                //$.inArray()方法得出元素(minH)在数组(hArr)中的index值;
                //console.log(value);
                //此时的value是第一行之后的所有的box元素的DOM对象!;
                $(value).css({
                    //$(value):将DOM对象转换成jQuery对象,才能继续使用jQuery方法;
                    "position":"absolute",
                    "top":minH+"px",
                    "left":minHIndex*w+"px"
                });
                hArr[minHIndex]+=$boxs.eq(index).outerHeight();
                //最低高元素的高度+刚添加到最低高度下的元素的高度=新的列高;
            };
        });
        console.log(hArr);
    };
    function checkScrollSlide () {
        var $lastBox=$("#main>div").last();
        var lastBoxDis=$lastBox.offset().top+Math.floor($lastBox.outerHeight()/2);
        var scrollTop=$(window).scrollTop();
        var documentH=$(window).height();
        return (lastBoxDis<scrollTop+documentH)?true:false;
    }

function up(id,address,author,photo) {
    layer.ready(function(){
        layer.open({
               type: 2,
               title: '正在对'+author+'进行编辑中~~~',
               shadeClose: true,
               shade: false,
               maxmin: true, //开启最大化最小化按钮
               area: ['400px', '420px'],

              content:'<%=path%>/html/uplist.jsp?id='+id+'&address='+address+'&author='+author+'&photo='+photo
   });
    });

}
function del(id) {
                var c= confirm("确认删除？")
                if(c){
                    location.href="<%=path%>/BlogServlet?act=del&id="+id;
                }
            }

</script>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    #main {
        position: relative;
    }
    .box {
        padding:15px 0 0 15px;
        float:left;
    }
    .pic {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0px 0px 5px #fffff5;
    }
    img {
        width:245px;
        height:auto;
    }
    #bt1{

        color: #ffedd7;
        background-color: #fffff5;
    }
     #bt2{

         color: #cecaff;
         background-color: #fffff5;
     }
</style>
<body>
<div id="main">
    <c:forEach var="b" items="${bloglist}">
    <div class="box">
        <div class="pic">
            <img id="image" src="<%=path%>/images/${b.blogPhoto}" alt="${b.blogAuthor}" title="${b.blogAuthor}的博客园">
        </div>
        <a href="${b.blogAddress}">${b.blogAddress}</a><br/>
        <div id="operation" style="position:absolute;background:#f4f5ff;opacity:0.5;filter:alpha(opacity=50);text-align:center;margin-top:-45px;z-index:20;width: 260px;height: 30px;border: 1px solid #ddf3ff;">
            <span  onclick="return up('${b.blogId}','${b.blogAddress}','${b.blogAuthor}','${b.blogPhoto}')" >修改</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span  onclick="return del(${b.blogId})">删除</span>
        </div>
    </div>
    </c:forEach>

</div>







</body>
</html>
