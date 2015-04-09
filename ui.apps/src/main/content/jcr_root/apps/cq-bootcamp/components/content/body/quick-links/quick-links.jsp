<%@ page import="com.ig.bootcamp.core.QuickLinkSupport" %>
<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>


<cq:text placeholder="quick links"/>
<div class="quickLinkWrapper">
    <ul>
        <li class="trigger">
            <div class="icon"><i class="fa fa-plus"></i></div>
            <div class="label"><cq:text value="${currentStyle.headTitle}" default="Quick Links"/></div>
        </li>

        <c:set var="quickLinkWrapper" value="<%=new QuickLinkSupport(resourceResolver, currentStyle.getPath())%>"/>
        <c:set var="quicklink" value="${quickLinkWrapper.quickLinkList}"/>
        <c:forEach items="${quicklink}" var="linkIterator">
            <li><a href="https://<c:out value="${linkIterator.link}"/>" target="_blank">
                <div class="icon"><i class="<c:out value="${linkIterator.icon}"/>"></i></div>
                <div class="label"><c:out value="${linkIterator.linkname}"/></div>
            </a></li>
        </c:forEach>
    </ul>
</div>
