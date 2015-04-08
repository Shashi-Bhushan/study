<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<c:choose>
    <c:when test="${mode}">
        <div class="spotlightWrapper ; ">
            <div class="slick-slider">
                <c:forEach var="i" begin="1" end="${properties.slides}">
                    <cq:include path="heroCarousel${i}"
                                resourceType="cq-bootcamp/components/content/body/carouselHeroSlide"/>
                </c:forEach>
            </div>
        </div>
        <div class="clearFix"></div>
    </c:when>
    <c:otherwise>
        <c:forEach var="i" begin="1" end="${properties.slides}">
            <div class="spotlightWrapper">
                <div class="slick-slider">
                    <cq:include path="heroCarousel${i}"
                                resourceType="cq-bootcamp/components/content/body/carouselHeroSlide"/>
                </div>
            </div>
        </c:forEach>

        <div class="clearFix"></div>
    </c:otherwise>
</c:choose>

<c:if test="${mode}">
    <script>
        $(document).ready(function () {

            $('.spotLightWrapper .slick-slider').slick({
                slidesToShow: 1,
                slidesToScroll: 1,

                dots: true,
                arrows: false

            });

            // get dots within the image itself
            $('.slick-dots').css("bottom", "0px");
            $('.spotLightWrapper').css("height", "768px");
        });
    </script>
</c:if>