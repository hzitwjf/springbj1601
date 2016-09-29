<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/28
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增学员</title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="css/bootstrap.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="css/bootstrap-theme.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="js/jquery-3.0.0.js"></script>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="js/bootstrap.js"></script>
  <script language="JavaScript">
    $(function(){
      $("#sub").click(function(){
        $("#sucess").fadeIn(1000);
        $.post("add",{"studentName":$("#studentName").val(),"loginPwd":$("#loginPwd").val(),
          "sex":$("#sex").val(),"gradeId":$("#gradeId").val(),"phone":$("#phone").val(),
          "address":$("#address").val(),"emall":$("#emall").val(),
          "identityCard":$("#identityCard").val()},function(data){
          if(data==1){
            $("#sucess").removeClass("alert-danger").addClass("alert alert-success");
            $("#sucess").html("增加成功");
            $("#sucess").fadeOut(2000);
            setTimeout("tiaozhuan()",1800);
          }else{
            $("#sucess").removeClass("alert-success").addClass("alert alert-danger");
            $("#sucess").html("增加失败");
            $("#sucess").fadeOut(3000);
          }
        });
      });
    });
    function tiaozhuan(){
      location="find";
    }
  </script>
</head>
<body>
<table class="table-bordered" align="center" style="width: 60%;" >
  <tr>
    <td align="center"><h2>新增学员信息</h2></td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">学生名字</div>
          <input class="form-control" type="text" placeholder="学生名字" name="studentName" id="studentName">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">学生密码</div>
          <input class="form-control" type="password" placeholder="学生密码" name="loginPwd" id="loginPwd">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">学生性别</div>
          <input class="form-control" type="number" placeholder="学生性别" name="sex" id="sex">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">所属年级</div>
          <select class="form-control" type="number" placeholder="所属年级" name="gradeId" id="gradeId">
            <c:forEach items="${grade}" var="g">
              <option value="${g.gradeId}">${g.gradeName}</option>
            </c:forEach>
          </select>
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">学生电话</div>
          <input class="form-control" type="text" placeholder="学生电话" name="phone" id="phone">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">居住地址</div>
          <input class="form-control" type="text" placeholder="居住地址" name="address" id="address">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">学生邮箱</div>
          <input class="form-control" type="email" placeholder="学生邮箱" name="emall" id="emall">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">身份证号</div>
          <input class="form-control" type="text" placeholder="身份证号" name="identityCard" id="identityCard">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td align="right"><button class="btn btn-primary" id="sub">新增学员</button></td>
  </tr>
</table>
<div role="alert" id="sucess" style="width: 60%;text-align: center;margin: 0 auto"></div>
</body>
</html>
