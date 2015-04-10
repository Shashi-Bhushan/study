$(document).ready(function () {
    setTimeout(function () {
        var el = $('#textBox').val();
        var path = $('#path').val();
        $.ajax({
            type: "GET",
            url: "/bin/newsfeed",
            data: {'path': path,
                'count': el },
            dataType: "json",
            success: function (data) {
                var len = parseInt(data.children.length);
                $("#textBox").val(len);
                var i = $(".newsFeed").dataAttr("number-of-news");

                $.each(data.children, function (index, item) {
                    if (index < i) {
                        $("#news").append("<li><a href=" + data.children[len - (index + 1)].id + ">" + data.children[len - (index + 1)].name + "<span>" + data.children[len - (index + 1)].date + "</span></a></li>");

                    }
                });
            },
            error: function () {
                //console.log("Error occured");
            }
        });
    }, 1000);
});