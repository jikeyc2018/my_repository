<%@ page import="com.wxc.hwt.Operate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询明细界面</title>
</head>
<link rel="stylesheet" href="jm.css">
<body>
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
        <span class="list">查询明细表</span>
        <p class="line-list"></p>
        <div style="width: 610px;margin: 0 auto;">
        <table border="1" cellpadding="0" cellspacing="0" align="center" width="600" height="40" >

            <tr align="center" bgcolor="#e1ffc1" >
                <td><b>卡号</b></td>
                <td><b>时间</b></td>
                <td><b>类型</b></td>
                <td><b>钱数</b></td>
            </tr>
      <%
          ArrayList<Operate> list=(ArrayList<Operate>)request.getAttribute("list");
          for(int i=0;i<list.size();i++){
              Operate o=list.get(i);
              %>

             <tr align="center" bgcolor="white">

                 <td> <%=o.getIDcard()%></td>
                 <td> <%=o.getTime()%></td>
                 <td> <%=o.getType()%></td>
                 <td> <%=o.getCash()%></td>

             </tr>


       <%
          }
      %>

        </table>
        <a  class="retu" href="show.jsp">返回</a>
        </div>









       <!--<%=session.getAttribute("IDcard")%>-->
       <!--<%=session.getAttribute("data1")%>-->
       <!--<%=session.getAttribute("type")%>-->
       <!--<%=session.getAttribute("cmoney")%>-->














    </div>
</div>

</body>
</html>
