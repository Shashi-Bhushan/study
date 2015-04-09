<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="spotlightWrapper">
    <div class="slick-slider" >
        <cq:include path="hero-carousel-slide-parsys" resourceType="foundation/components/parsys"/>
    </div>
</div>
<div style="clear:both;"></div>
<c:if test="${mode}">
    <script>
        $(document).ready(function () {
            $('.spotLightWrapper .slick-slider .hero-carousel-slide-parsys .new.section').remove();

            $('.spotLightWrapper .slick-slider .hero-carousel-slide-parsys').slick({
                slidesToShow: ${properties.showSlides},
                slidesToScroll: ${properties.scrollSlides},

                dots: true,
                arrows: true
            });
        });
    </script>
</c:if>
<div style="clear:both;"></div>
