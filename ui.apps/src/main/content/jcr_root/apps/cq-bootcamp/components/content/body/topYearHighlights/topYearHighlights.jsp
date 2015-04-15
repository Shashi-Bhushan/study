<%--
  topYearHighlights.jsp

  Copyright 2012 NASCAR
  All Rights Reserved.

  This software is the confidential and proprietary information of
  NASCAR, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with NASCAR.

  ==============================================================================

  Top Year Highlights Links (Digital Smith) Component

  This script is the default script that is executed for this component.
   ==============================================================================
--%>
<%@include file="/apps/nascar/foundation/global.jsp"%>
<cq:setContentBundle />
<div class="fatnavColumn col22 videoHighlightsFN">
    <h3>
        <fmt:message key="topHighlightsLabel" />
    </h3>
    <c:forEach items="${properties.season}" var="yearSelected"
        varStatus="loop">
        <article>
        <h4 class="hLights">
            <a class="video"
                href="${properties.digitalSmithPage}.${yearSelected}.html">
                <span class="icon textIndent"/>&nbsp;
                ${yearSelected} <fmt:message key="highlightsLabel" />
            </a>
        </h4>
        </article>
    </c:forEach>
    <cq:include path="linkList"
            resourceType="nascar/components/linklist" />
</div>