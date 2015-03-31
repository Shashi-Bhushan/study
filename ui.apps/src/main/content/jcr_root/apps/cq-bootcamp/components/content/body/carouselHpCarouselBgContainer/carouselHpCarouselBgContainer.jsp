<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<c:choose>
    <c:when test="${mode == false}">
        <c:set var="carouselHeight" value="auto"/>
    </c:when>
    <c:otherwise>
        <c:set var="carouselHeight" value="267px"/>
    </c:otherwise>
</c:choose>
<div class="hpCarouselBg carouselHpCarouselBgContainer" style='height:${carouselHeight};'>
    <div class="slick-slider">
        <c:forEach var="i" begin="1" end="${properties.slides}">
            <cq:include path="hpCarouselBg${i}"
                        resourceType="cq-bootcamp/components/content/body/carouselHpCarouselBgSlide"/>
        </c:forEach>
    </div>
</div>


<c:if test="${mode}">
<script>
    $(document).ready(function () {

        $('.hpCarouselBg .slick-slider').slick({
            slidesToShow: 1,
            slidesToScroll: 1,

            dots: false,
            arrows: true

        });

        // making buttons persist on mouse out also
        var prevObj = $('.hpCarouselBg .slick-prev');
        prevObj.mouseenter(function () {
            prevObj.css('background', 'url(/content/dam/cq-bootcamp/home-pg-carousel-arrow.png) 0 0 no-repeat');
        });
        var nextObj = $('.hpCarouselBg .slick-next');
        nextObj.mouseenter(function () {
            nextObj.css('background', 'url(/content/dam/cq-bootcamp/home-pg-carousel-arrow.png) 0 0 no-repeat');
            nextObj.css('right', '10px');
            nextObj.css('background-position', '-19px 0');
        });

    });
</script>
</c:if>