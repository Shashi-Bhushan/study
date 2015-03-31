<%@include file="/apps/cq-bootcamp/global.jsp" %>
<cq:include script="/libs/wcm/core/components/init/init.jsp"/>

<header>

    <div class="container">
        <div class="master">
            <div class="navWrapper" >
                <div class="logo">
                    <cq:include path="logo" resourceType="foundation/components/logo"/>
                </div>
                <div class="topRight">
                    <div class="cartWrap">
                        <cq:include path="stock" resourceType="cq-bootcamp/components/content/header/stock"/>
                    </div>
                    <div class="mobileTrigger">
                        <ul>
                            <li class="frst"></li>
                            <li class="scnd"></li>
                            <li class="thrd"></li>
                        </ul>
                    </div>
                        <cq:include path="Navigation" resourceType="cq-bootcamp/components/content/header/topNavigation"/>
                </div>
            </div>
        </div>
    </div>
</header>
