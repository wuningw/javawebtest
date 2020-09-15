<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020\4\23 0023
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNO>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNO-1}">上一页</a>
    </c:if>
    <c:choose>
        <c:when test="${requestScope.page.pageToal<=5}">
            <c:forEach begin="1" end="${requestScope.page.pageToal}" var="i">
                <c:if test="${i==requestScope.page.pageNO}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.page.pageNO}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageToal>5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNO<3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i==requestScope.page.pageNO}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNO}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNO>requestScope.page.pageToal-3}">
                    <c:forEach begin="${requestScope.page.pageToal-4}" end="${requestScope.page.pageToal}" var="i">
                        <c:if test="${i==requestScope.page.pageNO}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNO}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNO-2}" end="${requestScope.page.pageNO+2}" var="i">
                        <c:if test="${i==requestScope.page.pageNO}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNO}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:if test="${requestScope.page.pageNO<requestScope.page.pageToal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNO+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageToal}">末页</a>
    </c:if>
    共${requestScope.page.pageToal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNO}" name="pn"
             id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
</div>
<script type="text/javascript">
    $(function () {
        $("#searchPageBtn").click(function () {
            var pageNo = $("#pn_input").val();
            var pageTotal =${requestScope.page.pageToal};
            if (pageNo > 0 && pageNo <= pageTotal) {
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            } else {
                alert("您输入的不是有效页数，请输入为【0-${requestScope.page.pageToal}】的页数范围")
                return false;
            }

        });
    });

</script>
