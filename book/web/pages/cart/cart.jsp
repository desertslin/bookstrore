<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <!--静态包含base标签和css样式-->
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
           $(".deleteItem").click(function () {
               return  confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗？")
           });

           $("#clear").click(function () {
               return confirm("你确定要清空购物车吗？");
           });

           $(".updateCount").change(function () {
               var name = $(this).parent().parent().find("td:first");
               var count = this.value;
               var id = $(this).attr("bId");
               if (confirm("你确定将【"+ name +"】商品数量修改为【"+ count +"】吗？")){
                   location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&bId="+id;
               }else {
                   this.value = this.defaultValue;
               }
           });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <!--静态包含登录或注册成功的页面-->
    <%@include file="/pages/common/success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">当前购物车为空！</td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" style="width: 60px" type="text" value="${entry.value.count}" bId="${entry.value.id}"/>
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>

</div>
<!--静态包含页脚-->
<%@include file="/pages/common/foot.jsp"%>>
</body>
</html>