<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<input type="hidden" value="${properties.noResultsText}" id="noResult" name="noResult">

<form id="searchForm" method="post" action="#">
    <input type="hidden" value="${properties.searchIn}" id="path" name="path">
    <input type="text" placeholder="Search" id="searchThis" name="searchThis"/>
    <input type="button" id="searchResult" name="searchResult" value="Search"/>
</form>
<ul style="list-style-type: none" id=results>
</ul>
