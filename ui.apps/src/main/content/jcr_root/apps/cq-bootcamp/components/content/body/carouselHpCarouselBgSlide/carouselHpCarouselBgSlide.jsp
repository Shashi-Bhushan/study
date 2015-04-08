<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="col">
    <img src=
         <cq:text property="fileReference" placeholder="/content/dam/cq-bootcamp/home-products-thumbs4.jpg"
                  default="/content/dam/cq-bootcamp/home-products-thumbs4.jpg"/> id="prdThumb" alt="" >
    <div class='hpCarouselBgIcon <cq:text property="icon" placeholder="icn1" default="icn1"/>'></div>
</div>
<div class="col">
    <h2>Products</h2>

    <div class="subHeadWrap">
        <div class="subHead"><cq:text property="title" placeholder="Edit to Enter Title" default="Appliances"/></div>
    </div>
    <p><cq:text property="desc"
                placeholder="Edit to Enter a Description"
                default="Welcome to the world of fresh living with our range of domestic appliances. These appliances will help you discover the joy of fresh eating and living."/></p>

    <div class="buttonWrapper">
        <c:forEach items="${properties.links}" var="link">
            <div class="buttonGlbl"><a href="javascript:;"><span><i class="fa fa-arrow-right"></i> ${link}</span></a>
            </div>
        </c:forEach>
    </div>
</div>
<div class="clearFix"></div>