<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/8/13
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=basePath%>>"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="jslib/jquery-1.7.2.js"></script>
