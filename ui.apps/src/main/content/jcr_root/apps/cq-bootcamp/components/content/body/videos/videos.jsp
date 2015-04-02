<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<div class="twoColRight" style="padding:5px">
	<h1>
    	<cq:text property="title" placeholder="Edit to Enter Title" default="Default Value"/>
    </h1>
    <div>
        <input type="text" name="searchBar" placeholder="Search Channel"/>

    </div>
    <div class="mediaVideoWrapper" id="page_container">
        <p>Order By
            <select class="orderBy">
                <option value="relevance">Relevance</option>
                <option value="published">Published</option>
                <option value="viewCount">View Count</option>
                <option value="rating">Rating</option>
            </select>
            Max No. of Videos
            <select class="numVideos" id="numVideos">
            </select>
            Year
            <select class="year">
            </select>
        </p>
			<script id="video-template">
                <ul class="youtubeClass content">
                            {#names}
                                    <li style="width:25%;height:175px">
                                        <a class="mediaVideo" data-fancybox-type="iframe" data-fancybox-group="group1"
                                           title="{title}" href="http://www.youtube.com/embed/{id}">
                                            <img src="{image}" alt="" style="width:90%"/>
                                        </a>
                                        <span>{title}</span>
                                    </li>
                            {~n}
                            {/names}
                </ul>
			</script>
<div id="output"></div>
		<div class="page_navigation paginationWrapper"></div>
	</div>
</div>
<div style="clear:both"></div>

<c:choose>
    <c:when test="${properties.videos == null}">
        <%-- if null , give a default value--%>
        <script>
        $(document).ready(function(){
            $(".numVideos").append("<option>15</option>");
        });
        </script>
    </c:when>
    <c:otherwise>
        <%-- Empties select box first first --%>
        <script>
            $(document).ready(function(){
                 $(".numVideos").html("");
            });
        </script>
        <!-- Render each Number Author provide in Select option -->
        <c:forEach items="${properties.videos}" var="list" varStatus="loop">
            <script>
                // fills the select box
                $(".numVideos").append("<option>${list}</option>");
            });
            </script>
        </c:forEach>
    </c:otherwise>
</c:choose>

<div class="errorDiv" style="display:none">
	<cq:text property="errorMsg" placeholder="Error Fetching Videos for This Channel"/>
</div>

<script>
$(document).ready(function(){
    // initial call to function
    jQuery().showResultsOnPage({"search" : "","videos" : $(".numVideos").val(),"channel" :"${properties.channelName}" ,"orderBy" : $(".orderBy").val() });


    // on change of select box or search box
    jQuery('input[name="searchBar"],.numVideos,.orderBy,.year').change(function(){
        jQuery().showResultsOnPage({"search" : $('input[name="searchBar"]').val(),"videos" : $(".numVideos").val(),"channel" :"${properties.channelName}" , "orderBy" : $(".orderBy").val() });
    });
});
</script>