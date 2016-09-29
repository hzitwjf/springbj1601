<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/27
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                   <%--http://java.sun.com/jstl/core--%>
<html>
<head>
    <title>学员信息</title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="css/bootstrap.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="css/bootstrap-theme.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="js/jquery-3.0.0.js"></script>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="js/bootstrap.js"></script>
  <script>
    /*function shan(studentNo){
      var b=window.confirm("你确定要删除吗?")
      if(b){
        $.post({
          url: "delete?stuNo="+studentNo,
          success: function (data) {
            if(data==1){
              $("#sucess").html("删除成功");
              $("#sucess").addClass("alert alert-success");
              $("#sucess").fadeOut(3000);
              location.reload();
            }else{
              $("#sucess").html("删除失败");
              $("#sucess").addClass("alert alert-danger");
              $("#sucess").fadeOut(3000);
            }
          }
        });
      };
    };*/
    $(function(){
      $(".btn-danger").click(function(){
        var b=window.confirm("你确定要删除吗?")
        if(b){
          $("#sucess").fadeIn(1000);
          var num= $(this).attr("title")
          $.post("delete",{stuNo:num},function(data) {
            if (data == 1) {
              $("#sucess").removeClass("alert-danger").addClass("alert alert-success");
              $("#sucess").html("删除成功");
              $("#sucess").fadeOut(3000);
              location.reload();
            } else {
              $("#sucess").removeClass("alert-success").addClass("alert alert-danger");
              $("#sucess").html("删除失败");
            }
          });
        }
      });
    });

    /*function checkAll(checked)
    {
      //根据名字获取所有checkbox控件
      var allCheckBoxs=document.getElementsByName("checkbox") ;
      //循环设置控件为选中状态
      for (var i=0;i<allCheckBoxs.length ;i++){
        if(allCheckBoxs[i].type=="checkbox"){
          allCheckBoxs[i].checked=checked;
        }
      }
    }*/
    function quanxuan(){
      $(".check").attr("checked",true);
    }
    function fanxuan(){
      $(".check").attr("checked",false);
    }
  </script>
  <style type="text/css">
    td{
      text-align: center;
      font-size: 12px;
      font-family: 微软雅黑;
    }
    #fenye{
      width: 80%;
      text-align: center;
      margin: 0 auto;
    }
  </style>
</head>
<body>

<table class="table table-bordered table-hover" style="width: 80%;margin: 0 auto">
  <tr>
    <td>学号</td>
    <td>密码</td>
    <td>学员名字</td>
    <td>性别</td>
    <td>所属年级</td>
    <td>电话</td>
    <td>地址</td>
    <td>出生日期</td>
    <td>邮箱</td>
    <td>身份证</td>
    <td>编辑</td>
    <td>删除</td>
  </tr>
  <c:forEach items="${list.content}" var="stu">
  <tr>
    <td><input type="checkbox" value="${stu.studentNo}" class="check"></td>
    <td>${stu.loginPwd}</td>
    <td>${stu.studentName}</td>
    <td>${stu.sex}</td>
    <td>${stu.gradeName}</td>
    <td>${stu.phone}</td>
    <td>${stu.address}</td>
    <td>${stu.bornDate}</td>
    <td>${stu.emall}</td>
    <td>${stu.identityCard}</td>
    <td><a class="btn btn-info" href="toupdate?studentNo=${stu.studentNo}">编辑</a></td>
    <td><%--<a type="button" class="btn btn-danger" href="javascript:shan(${stu.studentNo}) ">删除</a>--%>
        <a class="btn btn-danger" title="${stu.studentNo}">删除</a>
    </td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="12">
      <button type="button" class="btn btn-warning" onclick="quanxuan()" ondblclick="fanxuan()">全选</button>
      <a type="button" class="btn btn-primary" href="insert">新增</a>
    </td>
  </tr>
</table>
<div id="fenye">
  <nav>
    <ul class="pagination">
      <li><a href="find?page=${courpage-1}">&laquo;</a></li>
      <c:forEach var="p" begin="0" end="${list.totalPages-1}" >
        <li><a href="find?page=${p}">${p+1}</a></li>
      </c:forEach>
      <c:if test="${courpage>list.totalPages-1}">
        <li><a href="javascript:void(0)">&laquo;</a></li>
      </c:if>
      <c:if test="${courpage<list.totalPages-1}">
        <li><a href="find?page=${courpage+1}">&raquo;</a></li>
      </c:if>
    </ul>


  </nav>
</div>
<div role="alert" id="sucess" style="width: 60%;text-align: center;margin: 0 auto"></div>
</body>
</html>
