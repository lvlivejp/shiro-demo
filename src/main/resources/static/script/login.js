$(function(){

    $('#login').click(function(){

        $.ajax({

            type: "POST",

            url: "/auth/login",

            data: {username:$("#userName").val(),
                password:$("#password").val()
            },

            dataType: "json",

            success: function(data){
                console.info(data);
                if(data.code!='0000'){

                }else{
                    window.location.href='/product/view'
                }
            },
            error : function(xhr,textStatus,errorThrown){
                console.info(textStatus);
                // window.location.href='/login/view'
            }

        });

    });

});