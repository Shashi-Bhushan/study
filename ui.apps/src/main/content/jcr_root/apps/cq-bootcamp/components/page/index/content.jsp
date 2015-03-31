<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="clearFix"></div>
<cq:include path="HeroCarouselContainerParsys" resourceType="foundation/components/parsys"/>

<div class="homePageWrapper">
    <div class="container">
        <div class="master">
            <div class="cardRow" style='height:${auto};'>
                	<cq:include path="Master Parsys" resourceType="foundation/components/parsys"/>
            </div>
            <div class="clearFix"></div>
        </div>
    </div>
</div>