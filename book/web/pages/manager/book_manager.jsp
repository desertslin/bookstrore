<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <!--静态包含base标签和css样式-->
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.delBtn1").click(function () {
                var td = $(this).parent().parent().children(":first");
                return confirm("确认删除《" + td.text() + "》吗");
            });
            $("#gotopage").click(function () {
                var pn = $("#pn_input").val();
                location.href = "${requestScope.page.url}&pn=" + pn;
            });
        });
    </script>
</head>
<body>

<!--静态包含后台管理菜单-->
<%@include file="/pages/common/manager_menu.jsp" %>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.pageData}" var="book">
            <%--将所有图书显示给用户--%>
            <tr>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="manager/bookManagerServlet?action=getBook&id=${book.id}&pn=${requestScope.page.pageNo}">修改</a>
                </td>
                <td><a class="delBtn1"
                       href="manager/bookManagerServlet?action=delete&id=${book.id}&pn=${requestScope.page.pageNo}">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pn=${requestScope.page.totalPage}">添加图书</a></td>
        </tr>
    </table>
    <%--静态包含分页代码--%>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>

<!--静态包含页脚-->
<%@include file="/pages/common/foot.jsp" %>
>
</body>
</html>