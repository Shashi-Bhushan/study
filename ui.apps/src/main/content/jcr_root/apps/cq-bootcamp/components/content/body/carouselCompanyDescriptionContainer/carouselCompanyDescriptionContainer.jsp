<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="havellsAtGlance carouselCardrowConainer">
    <div class="slick-slider ${height}">
        <cq:include path="companyDescription" resourceType="foundation/components/parsys"/>
    </div>
</div>
<c:if test="${isPreview}">
    <script>
        $(document).ready(function(){
            $('.havellsAtGlance .slick-slider .companyDescription').slick({
                slidesToShow: 1,
                slidesToScroll: 1,
                dots: true,
                arrows: false

            });
            $('.havellsAtGlance .slick-slider .companyDescription').slick(
                    'slickRemove',($('.havellsAtGlance .slick-slider .companyDescription .slick-list .slick-track').children().length -2) - 1);

        });
    </script>
</c:if>

