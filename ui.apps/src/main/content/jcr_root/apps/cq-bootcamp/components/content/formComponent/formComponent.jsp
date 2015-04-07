<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>

<div class="midContainer">
    <div class="container">
        <div class="master">
            <div class="signUpWrap noBg">
                <form id="signUpform" method="post">
                    <div id="status" style='color:green'></div>
                    <cq:text tagName="h1" placeholder="[Enter Text]" default="Sign Up" property="text"/>

                    <div class="col">
                        <div id="emailMessage" style='color:red'></div>
                        <input name="email" id="email" type="email" class="input" required placeholder="Email Address">
                        <div id="passwordMessage" style='color:red'></div>
                        <input name="password" id="password" type="password" class="input" required placeholder="Passwords">
                        <div id="confirmPasswordMessage" style='color:red'></div>
                        <input name="confirmPassword" id="confirmPassword" type="password" class="input" required placeholder="Repeat">
                        <input name="userName" id="userName" type="text" class="input" required placeholder="User Name">
                        <input name="name" id="name" type="text" class="input" required placeholder="Name">
                        <input name="surname" id="surname" type="text" class="input" required placeholder="Surname">
                    </div>
                    <div class="col">
                        <div id="mobileMessage" style='color:red'></div>
                        <input name="mobile" id="mobile" type="text" class="input" required placeholder="Mobile">
                        <input name="dob" id="dob" type="date" class="input" placeholder="Date of Birth">
                        <textarea name="billingAddress" id="billingAddress" cols="" rows="" class="txtArea" required placeholder="Billing Address"></textarea>
                        <textarea name="shippingAddress" id="shippingAddress" cols="" rows="" class="txtArea" required placeholder="Shipping Address"></textarea></div>


                    <div class="buttonWrapper">
                        <div class="buttonGlbl"><a href="javascript:;" id="signup" ><span><i class="fa fa-arrow-right"></i>${properties.btntext}</span></a></div>
                        <div id="validation" style='color:green'></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div style="clear: both"></div>


