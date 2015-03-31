<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="carouselHeroSlide" style='background-image:url(<cq:text property="fileReference" placeholder="/content/dam/cq-bootcamp/spotlight1.jpg" default="/content/dam/cq-bootcamp/spotlight1.jpg"/>); '>

    <div class='spotlightContentLeft <cq:text property="color" placeholder="red" default="red"/>'>
        <div class="content">
            <div class="heading"><cq:text property="title" placeholder="Edit to Enter a Title"
                                          default="Corporate Social Responsibility"/></div>
            <cq:text property="desc"
                     placeholder="Edit to Enter a Description   "
                     default="When we create a brand story with a difference, the result is an unusual set of products, offerings and deep connect with the end customer."/>

            <div class="buttonWrapper">
                <c:forEach items="${properties.links}" var="link">
                    <div class="buttonGlbl"><a href="javascript:;"><span><i
                            class="fa fa-arrow-right"></i> ${link}</span></a></div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class='spotlightContentRight <cq:text property="colorRight" placeholder="red" default="red"/>'></div>
</div>
<br/>

