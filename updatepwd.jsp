
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码界面</title>

</head>
<link rel="stylesheet" href="jm.css">
<body>
<script src="../JS/jquery-3.2.0.js" type="text/javascript" ></script>
<script src="../JS/bootstrap.min.js"></script>

<script>
function checkpasswd(){
var pwd1 = document.getElementById("pwd1").value;
var pwd2 = document.getElementById("pwd2").value;
if(pwd1==""||pwd2==""){
    alert("你的密码不能为空");
    return false;
}
if(pwd1==pwd2){
return true;
}else{
window.alert("两次输入密码不一致");
return false;
}
}
</script>






<div class="wrapper-top">
    <div class="content-top">
        <a href="#">logo</a>
        <ul>
            <li class="top-1"></li>
            <li class="top-2">融e购</li>
            <li class="top-3">登录|注册</li>
        </ul>
        <form action="#" method="post">
            <input class="shuru" type="text" name="name">
            <input class="search"  type="submit">

        </form>

    </div>
</div>




<div class="wrapper-box" style="margin-top: 60px">
    <div class="content-box">
         <div class="uppwd-box">
         <span >欢迎您进入银行管理系统</span>
         <p class="line"></p>
         <form action="UpdaServlet" method="post">
         <h3>新的密码:<input  id="pwd1"    type="password" name="pwd1"></h3>
         <h3>确认密码:<input  id="pwd2"    type="password" name="pwd2"></h3>
          <input class="but1" type="submit" name="button" id="submit" value="确认"    onclick="return checkpasswd()" />
          <input class="but1" type="reset" id="reset">


         </form>
         <a href="show.jsp">返回上一页</a>


         </div>



    </div>
</div>

</body>
</html>
