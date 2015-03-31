<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>
<ul>
    <li>
        <div class="label">
            <cq:text value="${currentStyle.stockName}" placeholder="Edit to Enter Title" default="NSE"/>
        </div>
        <div class='nseValue <cq:text value="${currentStyle.status}" placeholder="up" default="up"/>'>
            <cq:text value="${currentStyle.stockPrice}" placeholder="200" default="200"/>
            <i class='fa fa-arrow-<cq:text value="${currentStyle.status}" placeholder="up" default="up"/>'></i></div>
    </li>
</ul>