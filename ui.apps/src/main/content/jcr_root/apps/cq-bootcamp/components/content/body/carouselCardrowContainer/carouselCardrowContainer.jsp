<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="havellsAtGlance carouselCardrowConainer">
    <div class="slick-slider ${height}">
        <c:forEach var="i" begin="1" end="${properties.slides}">
            <cq:include path="cardrowCarousel${i}" resourceType="cq-bootcamp/components/content/body/carouselCardrowSlide"/>
        </c:forEach>
    </div>
</div>

<c:if test="${mode}">
<script>
    $(document).ready(function () {
        $('.havellsAtGlance .slick-slider').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            dots: true,
            arrows: false

        });

        // get dots within the image itself
        $('.slick-dots').css("bottom", "0px");
    });
</script>
</c:if>