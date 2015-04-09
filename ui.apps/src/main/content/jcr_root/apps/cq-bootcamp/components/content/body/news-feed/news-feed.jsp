<%@include file="/libs/foundation/global.jsp" %>
<%@page session="false" %>
<div class="cardRow">
    <div class="col newsAndUpdates">
        <div class="newsWrap" style="overflow-y:auto; overflow-x:auto;height:180px:width:450px">
            <h2>News &amp; Updates</h2>
            <ul id="news">
            </ul>
            <input type="hidden" value="0" id="textBox"/>
            <input type="hidden" value=${properties.newspath}   id="path"/>
        </div>
    </div>
</div>
<div class="newsFeed" number-of-news="${properties.news}">
</div>
