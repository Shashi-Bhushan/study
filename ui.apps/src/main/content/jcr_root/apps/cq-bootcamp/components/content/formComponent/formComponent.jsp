<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>



<div class="midContainer">
    <div class="container">
        <div class="master">
            <div class="signUpWrap noBg">

                <form id="signUpform" method="post">

                    <cq:text tagName="h1" placeholder="[Enter Text]" default="Sign Up" property="text"/>

                    <div class="col">
                        <input name="email" id="email" type="email" class="input" required placeholder="Email Address">
                        <input name="password" id="password" type="password" class="input" required placeholder="Passwords">
                        <input name="confirmPassword" id="confirmPassword" type="password" class="input" required placeholder="Repeat">
                        <input name="userName" id="userName" type="text" class="input" required placeholder="User Name">
                        <input name="name" id="name" type="text" class="input" required placeholder="Name">
                        <input name="surname" id="surname" type="text" class="input" required placeholder="Surname">
                    </div>
                    <div class="col">
                        <input name="mobile" id="mobile" type="text" class="input" required placeholder="Mobile">
                        <input name="dob" id="dob" type="date" class="input" placeholder="Date of Birth">
                        <textarea name="billingAddress" id="billingAddress" cols="" rows="" class="txtArea" required placeholder="Billing Address"></textarea>
                        <textarea name="shippingAddress" id="shippingAddress" cols="" rows="" class="txtArea" required placeholder="Shipping Address"></textarea></div>


                    <div class="buttonWrapper">
                        <div class="buttonGlbl"><a href="javascript:;" id="signup" ><span><i class="fa fa-arrow-right"></i>${properties.btntext}</span></a></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div style="clear: both"></div>


