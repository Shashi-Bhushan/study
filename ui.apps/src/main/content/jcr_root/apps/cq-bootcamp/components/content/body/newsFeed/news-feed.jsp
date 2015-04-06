<%@include file="/apps/cq-bootcamp/components/global.jsp" %>
<%@page session="false" %>
<script>
    $(document).ready(function () {
        setTimeout(function () {
            var el = $('#t1').val();
            var path = $('#path').val();
            $.ajax({
                type: "GET",
                url: "/bin/service/news",
                data: {'path': path,
                    'val': el },
                   dataType: "json",
                success: function (data) {
                    var len = parseInt(data.children.length);
                    $("#t1").val(len);
                    var i = 1;
                    $.each(data.children, function (index, item) {
                        if (i <= 10) {
                 $("#news").append("<li><a href=" + data.children[len - i].id + ">" + data.children[len - i].name + "<span>" + data.children[len - i].date + "</span></a></li>");
                            i++;
                        } });
                },
                error: function () {
                    alert("error occured!!!" + el);
                }
            });
        }, 1000);
    });
</script>
<div class="newsWrap" style="overflow-y:auto; overflow-x:auto;height:180px:width:450px">
    <h2>News &amp; Updates</h2>
    <ul id="news">
    </ul>
    <input type="hidden" value="0" id="t1"/>
    <input type="hidden" value=${properties.newspath} id="path"/>
</div>
