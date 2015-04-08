<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<ul>
    <li>
        <div class="label">
            <input id="stockName" type="hidden" value=" ${currentStyle.stockName}"/>
            ${currentStyle.stockName}
        </div>
        <div class='nseValue '>
        </div>
    </li>
</ul>