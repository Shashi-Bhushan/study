$(document).ready(function(){
    $(".anchor").eq(0).addClass("active");
    $(".managementContent").hide();
    $(".managementContent").eq(0).show();
    function milestoneTab(object){
        $(".managementContent").hide();
        $(".anchor").removeClass("active");
        $(".anchor").eq(object-1).addClass("active");
        $(".managementContent").eq(object-1).show();
    }
    $(".anchor").click(function(){
        var count=$(this).parents("li").attr("data-counter");
        milestoneTab(count);
    })
})
