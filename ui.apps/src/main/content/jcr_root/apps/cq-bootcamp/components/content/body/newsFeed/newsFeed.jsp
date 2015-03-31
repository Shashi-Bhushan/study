<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<script>
    $(document).ready(function () {
        setInterval(function () {
            var length = $("#length").val();

            $.ajax({
                type: "GET",
                url: "/bin/service/rss?length=" + length,
                dataType: "json",
                //if received a response from the server
                success: function (data) {

                    $.each(data, function (i, item) {
                        $("#news").append("<li><a href=" + item.id + ">" + item.name + "<span>" + $.datepicker.formatDate('d M yy', new Date()) + "</span></a></li>");
                        $("#length").val(data.length);
                    });

                },
                error: function () {
                    console.log("error occured!!!");
                }
            });
        }, 3000);
    });

</script>
<div class="newsAndUpdates newsFeed1">
    <div class="newsWrap newsFeed2">
        <h2>News &amp; Updates</h2>
        <ul id="news">
        </ul>
        <input type="hidden" value="0" id="length"/>
    </div>
</div>