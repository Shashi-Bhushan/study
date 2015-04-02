<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<input type="hidden" value="${properties.noResultsText}" id="noResult" name="noResult">
<input type="hidden" value="${properties.searchIn}" id="path" name="path">
<input type="text" placeholder="Search" id="searchThis" name="searchThis"/>
<input type="submit" id="searchResult" name="searchResult"/>

<script>
    $("#searchResult").click(function () {
        var path = $("#path").val();
        var search = $("#searchThis").val();

        $.ajax({
            type: 'GET',
            url: "/bin/service/search?search=" + search + "&path=" + path,
            dataType: "json",

            success: function (data) {
                var searchresult = "";
                $.each(data.data, function (i, item) {
                    searchresult = searchresult + "<li><a target='_blank' href=" + item.path + ".html>" + item.title + "</a><br><span>" + item.path + "</span></li>";
                });
                if (searchresult == "") {
                    $('#results').html($("#noResult").val());
                }
                else {
                    $('#results').html(searchresult);
                }
            },
            error: function () {
                $('#results').html("Please Enter Something to Search!!");
            }
        });
    });
</script>
<ul style="list-style-type: none" id=results>
</ul>
