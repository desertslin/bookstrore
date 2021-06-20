<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <!--静态包含base标签和css样式-->
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>

<!--静态包含后台管理菜单-->
<%@include file="/pages/common/manager_menu.jsp" %>

<div id="main">
    <form action="manager/bookManagerServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${book.id}">
        <input type="hidden" name="pn" value="${param.pn}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="${book.title}"/></td>
                <td><input name="price" type="text" value="${book.price}"/></td>
                <td><input name="author" type="text" value="${book.author}"/></td>
                <td><input name="sales" type="text" value="${book.sales}"/></td>
                <td><input name="stock" type="text" value="${book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<!--静态包含页脚-->
<%@include file="/pages/common/foot.jsp" %>
>
</body>
</html>