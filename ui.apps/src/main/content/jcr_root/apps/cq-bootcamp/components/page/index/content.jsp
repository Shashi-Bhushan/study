<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="clearFix"></div>
<div style='height:${heroCarouselHeight};'>
    <cq:include path="hero-carousel-container-parsys" resourceType="foundation/components/parsys"/>
</div>
<cq:include path="quick-links" resourceType="cq-bootcamp/components/content/body/quick-links"/>
<div class="homePageWrapper">
    <div class="container">
        <div class="master">
            <div class="cardRow" style='height:${auto};'>
                <cq:include path="master-parsys" resourceType="foundation/components/parsys"/>
            </div>
            <div class="clearFix"></div>
        </div>
    </div>
</div>
