$(document).ready(function () {
    var stockName = $("#stockName").val();
    var stockStatus;
    $.ajax({
        type: "get",
        url: "http://finance.google.com/finance/info?client=ig&q=" + stockName,
        success: function (data) {
            data = data.slice(3);
            var jsonObj = JSON.parse(data);
            if (jsonObj[0].c_fix > 0)
                stockStatus = "up";
            else
                stockStatus = "down";
            $('.nseValue').append(jsonObj[0].l_cur + "<i class='fa fa-arrow-" + stockStatus + "'></i></div>");

        },
        error: function (data) {
            console.log("Error Occured");
        }

    });
});




