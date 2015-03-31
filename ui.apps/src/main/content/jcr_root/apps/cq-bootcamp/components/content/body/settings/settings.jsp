<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="havellsConnectBg">
    <div class="havellsConnectOptionWrapper settings">
        <ul>
            <c:forEach begin="1" end="3" var="index">
            <li class='<cq:text property="icon${index}" placeholder="icn${index}" default="icn${index}"/>'>
                <a href="javascript:;">
                    <strong>
                        <cq:text property="title${index}" placeholder="Edit to Enter a Title" default="Intelligrape CONNECT"/>
                    </strong>
                    <cq:text property="desc${index}"
                             placeholder="Edit to enter a Description"
                             default="The first FMEG Company that offers door step service, be it a switch or a motor"/>
                </a>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div style="clear:both"></div>
