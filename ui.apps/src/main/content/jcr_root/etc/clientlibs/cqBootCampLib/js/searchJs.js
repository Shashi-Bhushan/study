$(document).ready(function () {

    $("#searchResult").click(function () {
        var path = $("#path").val();
        var searchThis = $("#searchThis").val();
        $.ajax({
            type: 'GET',
            url: "/bin/service/search",
            data: $('form').serialize(),
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


});
