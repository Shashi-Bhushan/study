    $(document).ready(function()
        {  var path=$("#path").val();    
            $.ajax({
            type: "GET",
            url: "/bin/dealer",
            dataType: "json",
                data: { 'path1':path      },
            success:  function (data) {
                $('#state option:not(:first)').remove();
                $.each(data.States,function(i,item)
                {
                    $("#state").append("<option value="+item.id+">"+item.name+"</option>");});  },
            error:function(){
            //console.log("error");
            }
        });
            $( "#state" ).change(function() {
              var path=$("#path").val();  
                var stateError=$("#stateError").val();
                var state= $('#state option:selected').val();

                if ( $("#state").val()!="states")
           {  $.ajax({
                    type: "GET",
                    url: "/bin/dealer",
                    dataType: "json",
                    data: {'path1':path ,
                        'state':state },
                    success:  function  (data) {
                     $('#cities option:not(:first)').remove();
                        $.each(data.States,function(i,item)
                        {
                            $("#cities").append("<option value="+item.id+">"+item.name+"</option>");
                        });   }, 

                    error:function (){
                         //console.log("error");

                    }  }); }
                else
                {
                     $('#cities option:not(:first)').remove();
                }});
            $( ".submit" ).click(function() {
                var path=$("#path").val(); 
                var errorMessage = $("#Error").val();
                var state = $('#state option:selected').val();
                var city= $('#cities option:selected').val();


                 if ( $('#cities').val()!="cities")
                {$.ajax({
                    type: "GET",
                    url: "/bin/dealer",
                    dataType: "json",
                     data: {'path1':path,
                            'state':state,
                            'city':city},
                    success:  function  (data) {
                         $("#message").text("");
                        $('tbody tr:not(:first)').remove();
                        var count=1;
                        $.each(data.States,function(i,item)
                        {
                            $("#table").append("<tr><td>"+ count++ +"</td><td>"+item.dealerName+"</td><td>"+item.address+"</            td><td>"+item.contact+"</td><td>"+item.email+"</td></tr>");
                        });  },

                    error:function (){
                        $('tbody tr:not(:first)').remove();
}});}
              else
                {
                   $("#message").text(errorMessage);
                    $('tbody tr:not(:first)').remove();
                }
            });
        });


