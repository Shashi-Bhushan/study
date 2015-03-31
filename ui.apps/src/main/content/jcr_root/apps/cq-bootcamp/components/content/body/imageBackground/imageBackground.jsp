<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="cardrow">
    <div class="hpCsrBg"
         style='background-image: url( <cq:text property="fileReference" placeholder="/content/dam/cq-bootcamp/hp-csr-bg.jpg" default="/content/dam/cq-bootcamp/hp-csr-bg.jpg"/>);'>
        <div class="col">
            <div class="sliderWrapper">
                <h2>
                    <cq:text property="title" placeholder="Edit to Enter a Title"
                             default="Corporate Social Responsibility"/>
                </h2>
                <div class="subHead">
                    <cq:text property="subHeading"
                             placeholder="Edit to Enter a Sub-Heading"
                             default="Intelligrape Pvt Ltd. is committed to the cause of Software development."/>
                </div>
                <p>
                    <cq:text property="desc"
                             placeholder="Edit to Enter a Description"
                             default="The company provides mid-day meals to about 0,000 school children every day in around 3.50 government schools in Alwar district."/>
                </p>
                <div class="buttonWrapper">
                    <c:forEach items="${properties.links}" var="link">
                        <div class="buttonGlbl"><a href="javascript:;"><span><i
                                class="fa fa-arrow-right"></i> ${link}</span></a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col">&nbsp;</div>
    </div>
</div>
<div class="clearFix"></div>