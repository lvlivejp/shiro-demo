$(function(){

    $('#edit').click(function(){

        $.ajax({

            type: "PUT",

            url: "/rest/product",

            data: {productCode:"1",
                productName:"商品1",
                count:"200"
            },

            dataType: "json",

            success: function(data){
                console.info(data);
            }

        });

    });

});