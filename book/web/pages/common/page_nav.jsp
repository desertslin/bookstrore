<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/8/17
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${requestScope.page.url}&pn=1">首页</a>
    <!--当总页数小于5，直接显示-->
    <c:if test="${requestScope.page.totalPage <= 5}">
        <c:set var="begin" value="1" scope="page" />
        <c:set var="end" value="${requestScope.page.totalPage}" scope="page" />
    </c:if>
    <%--当总页数大于五，分情况讨论--%>
    <c:if test="${requestScope.page.totalPage > 5}">
        <%--当前页数小于3，显示前五页--%>
        <c:if test="${requestScope.page.pageNo <= 3}">
            <c:set var="begin" value="1" scope="page" />
            <c:set var="end" value="5" scope="page" />
        </c:if>
        <%--中间的，当前页在中间--%>
        <c:if test="${requestScope.page.pageNo > 3 && requestScope.page.pageNo <= requestScope.page.totalPage - 3}">
            <c:set var="begin" value="${requestScope.page.pageNo - 2}" scope="page" />
            <c:set var="end" value="${requestScope.page.pageNo + 2}" scope="page" />
        </c:if>
        <%--当前页数在后三页，显示后五页--%>
        <c:if test="${requestScope.page.pageNo > requestScope.page.totalPage - 3}">
            <c:set var="begin" value="${requestScope.page.totalPage - 4}" scope="page" />
            <c:set var="end" value="${requestScope.page.totalPage}" scope="page" />
        </c:if>
    </c:if>
    <c:if test="${requestScope.page.hasPrev}">
        <a href="${requestScope.page.url}&pn=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>
    <c:forEach begin="${begin}" end="${end}" var="pnum">
        <c:if test="${requestScope.page.pageNo != pnum}">
            <a href="${requestScope.page.url}&pn=${pnum}">${pnum}</a>
        </c:if>
        <c:if test="${requestScope.page.pageNo == pnum}">
            【${requestScope.page.pageNo}】
        </c:if>
    </c:forEach><c:if test="${requestScope.page.hasNext}">
    <a href="${requestScope.page.url}&pn=${requestScope.page.pageNo + 1}">下一页</a>
</c:if>
    <a href="${requestScope.page.url}&pn=${requestScope.page.totalPage}">末页</a>
    共${requestScope.page.totalPage}页，${requestScope.page.totalCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>
    <页></页>
    <input type="button" value="确定" id="gotopage">
</div>
