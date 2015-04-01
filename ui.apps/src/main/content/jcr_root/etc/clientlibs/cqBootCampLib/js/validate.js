$(document).ready(function() {
    $("#signup").click(function(){

        var userName=$("#userName").val();
        var email=$("#email").val();
        var password=$("#password").val();
        var cpassword=$("#confirmPassword").val();
        var mobile=$("#mobile").val();
        var name=$("#name").val();
        var surname=$("#surname").val();
        var dob=$("#dob").val();
        var billingAddress=$("#billingAddress").val();
        var shippingAddress=$("#shippingAddress").val();

        /* var uname= $("#userName").val(); var sname= $("#surName").val(); var description=$("#udesc").val();*/

        var phoneRegex = /^\d{10}$/;
        var emailRegex = /^[A-Za-z0-9]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
        var passRegex= /^(?=.*?[A-Z])(?=.*?[0-9]).{6,}$/;

        if(email==""|| (!emailRegex.test(email)))
        {
            alert("Please enter proper email")
            $(email).focus();
        }

        else if((!passRegex.test(password)) || (!passRegex.test(cpassword)))
        {
            alert("Please enter correct password!! with atleast one capital, one number and minimum of 6 characters.")
            $(password).focus();
        }

        else if(!(password==cpassword))
        {
            alert("Enter Same Password!!")
            $(password).focus();
        }

        else if(!(phoneRegex.test(mobile)))
        {
            alert("Enter Correct Mobile Number!!")
            $(mobile).focus();
        }

        else

        {
          alert("All Validation Correct!!")
          $.ajax({
            type: "POST",
            url: "/bin/service/user",
            data:$('form').serialize(),
            success:  function (data) {
                alert("Successful SignUp!!");
            },
            error:function(){
                alert("error occured!!!");
            }
        });
        }
    });



});