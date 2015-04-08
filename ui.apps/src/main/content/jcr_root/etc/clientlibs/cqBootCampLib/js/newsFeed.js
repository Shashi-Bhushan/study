$(document).ready(function(){
    $.fn.renderFeed = function(){
        // checks for feeds after every 30 seconds
        setInterval(function () {
            var length = $("#length").val();

            $.ajax({
                type: "GET",
                url: "/bin/service/rss?length=" + length,
                dataType: "json",
                //if received a response from the server
                success: function (data) {

                    $.each(data, function (i, item) {
                        $("#news").append("<li><a href=" + item.id + ">" + item.name + "<span>"
                            + $.datepicker.formatDate('d M yy', new Date()) + "</span></a></li>");
                        $("#length").val(data.length);
                    });

                },
                error: function () {
                    console.log("Error occurred while fetching Feeds");
                }
            });
        }, 30000);
    }
});