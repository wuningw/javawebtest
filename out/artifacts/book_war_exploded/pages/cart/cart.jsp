<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%--静态包含--%>
    <%@include file="/pages/common/login_sucess_menu.jsp" %>
</div>

<div id="main">

    <table>
        <c:if test="${empty sessionScope.cart.items}">

            <tr>
                <td colspan="5"><a href="index.jsp">亲，购物车空空了,去购物吧！！！</a></td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">

            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input class="update_cout" style="width: 50px" type="text" bookId="${entry.value.id}" value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="delete_item" href="CartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clear_item" href="CartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
    $(function () {

        $(".delete_item").click(function () {

            return confirm("您确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
        });
        $(".clear_item").click(function () {
            return confirm("您确定要清空购物车吗？");
        });
        $(".update_cout").change(function () {
            let name = $(this).parent().parent().find("td:first").text();
            let count = this.value;
            let id=$(this).attr("bookId");
            if (confirm("您确定要修改【" + name + "】的数量为" + count + "吗？")) {
                 location.href="<%=basePath%>CartServlet?action=updateCount&count="+count+"&id="+id;
            } else {
                this.value = this.defaultValue;
            }

        });
    })
</script>
</html>