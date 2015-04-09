<%
%><%@include file="/apps/cq-bootcamp/global.jsp"%><%
%><%@page session="false" %><%
%>
 <div class="twoColRight">
 <cq:text tagName="h1" property="title" placeholder="[Enter Title]" default=""/>
 <div class="managementWrapper">
 <div class="managementProfile">
 <ul>
    <c:forEach var="profile" begin="1" end="${properties.slide}" varStatus="status">
    <li data-counter="${status.count}">
    <cq:include path="sl-${profile}" resourceType="/apps/cq-bootcamp/components/content/body/managementProfileComponent"/>
    </li>
	</c:forEach>
 </ul>
 </div>
 <c:forEach var="profile" begin="1" end="${properties.slide}" varStatus="status">
 <div class="managementContent">
 <cq:include path="par-${profile}" resourceType="foundation/components/parsys"/>
 </div>
 </c:forEach>
 </div>
 </div>



