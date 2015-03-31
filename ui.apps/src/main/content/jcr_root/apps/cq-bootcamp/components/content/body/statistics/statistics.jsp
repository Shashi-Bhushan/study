<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="cardRow">
    <div class="col">
        <img src='
        <cq:text property="fileReference" placeholder="/content/dam/cq-bootcamp/home-infra-thumb.jpg" default="/content/dam/cq-bootcamp/home-infra-thumb.jpg"/>'
             alt="Alternate Text" class="master4">
    </div>
    <div class="col infraBg">
        <div class="sliderWrapper">
            <h2>
                <cq:text property="title" placeholder="Edit to Enter a Title" default="Infrastructure"/>
            </h2>
            <p>
                <cq:text property="desc"
                         placeholder="Edit to Enter a description and Statistics"
                         default="Intelligrape entered software development business in mid-2003 and has emerged as one of the fastest growing Fan brand in the Indian market. Intelligrape has captured the customers fancy with innovative..."/>
            </p>
            <div class="infraRow">
                <ul>
                    <li>
                        <div class="numbers">
                            <cq:text property="country" placeholder="0" default="0"/>
                        </div>
                        <div class="label">Countries</div>
                    </li>
                    <li>
                        <div class="numbers">
                            <cq:text property="branch" placeholder="0" default="0"/>
                        </div>
                        <div class="label">Branch Offices</div>
                    </li>
                    <li>
                        <div class="numbers">
                            <cq:text property="units" placeholder="0" default="0"/>
                        </div>
                        <div class="label">Manufacturing Units&nbsp;Worldwide</div>
                    </li>
                    <li>
                        <div class="numbers">
                            <cq:text property="network" placeholder="0" default="0"/>
                        </div>
                        <div class="label">Distribution Network</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clearFix"></div>