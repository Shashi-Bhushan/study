<%@include file="/libs/foundation/global.jsp" %>
<%@page session="false" %>
This is the custom xtype component  <br/>
<c:forEach var="color" varStatus="loop" items="${properties.colors}">
	     <span style="color:${color};font-weight: bold"> <c:out value="${color}"/> </span><br/>
</c:forEach>
<div style="clear: both"></div>

