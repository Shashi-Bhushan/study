<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>


<footer>
    <div class="container">
        <div class="master">
            <div class="col">
                <cq:include path="footer1" resourceType="cq-bootcamp/components/content/footer/multiLink"/>
            </div>
            <div class="col">
                <cq:include path="footer2" resourceType="cq-bootcamp/components/content/footer/multiLink"/>
            </div>
            <div class="col">
                <cq:include path="footer3" resourceType="cq-bootcamp/components/content/footer/multiLink"/>
            </div>
            <div class="col">
                <cq:include path="footer4" resourceType="cq-bootcamp/components/content/footer/multiLink"/>
            </div>
            <div class="col">
                <cq:include path="footer5" resourceType="cq-bootcamp/components/content/footer/multiLink"/>
            </div>

            <div class="col">
                <cq:include path="findUs" resourceType="cq-bootcamp/components/content/footer/findUs"/>
            </div>
        </div>
        <div class="copyRightWrapper">
            <div class="left">
                &copy; Copyright <fmt:formatDate pattern="yyyy" value="${now}"/> by Intelligrape. All rights reserved
            </div>
        </div>
    </div>
</footer>
