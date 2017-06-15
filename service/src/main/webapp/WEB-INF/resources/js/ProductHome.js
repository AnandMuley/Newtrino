var index = 0;
$(document).ready(function(){
    $( "#spinner" ).spinner();

    $('#addNutrient').click(function(){
        $('#nutrientsContainer').append(fnGenerateNutrient());
    });

    $('#productImage').click(function(){
        $('#prodImg').click();
    });

    $('#prodImg').change(function(){
        fetchPreviewImage(this);
        $('#imageSubText').text('Image Preview').css('color','#09AE85');
    });

    $('.catalogueItem').mousedown(function(e){
        var title = this.title;
        if(e.which == 2){
            $.ajax({
                type: "POST",
                url : "delete",
                data : {pname:title}
            }).done(function(msg){
                if(msg == "success"){
                    // Something went wrong
                    $('#prodItem_'+title).remove();
                }
            });
        }

    });

    $('#nutrientsModal').on('show.bs.modal',function(event){
        var imgThumbnail = $(event.relatedTarget);
        var prodName = imgThumbnail.data('title');

        // Update modal contents
        var modal = $(this);
        modal.find('.modal-title').text('Nutrients in '+prodName);

        var nutrients = $('#nutrients_'+prodName).html();
        modal.find('.modal-body').html(nutrients);


    });

});

function fetchPreviewImage(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#productImage').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

function fnGenerateNutrient(){
    index++;
    var nutrientRow = '<div class="row">';
    nutrientRow += '<div class="col-xs-4 col-lg-4 nutrients-row">';
    nutrientRow += '<input name="nutrientDtos['+index+'].name" type="text" class="form-control input-lg" placeholder="Name" />';
    nutrientRow += '</div>';
    nutrientRow += '<div class="col-xs-4 col-lg-4 nutrients-row">';
    nutrientRow += '<input name="nutrientDtos['+index+'].unitDto.quantity" type="text" class="form-control input-lg" placeholder="Unit Value" />';
    nutrientRow += '</div>';
    nutrientRow += '<div class="col-xs-4 col-lg-4 nutrients-row">';
    nutrientRow += '<select name="nutrientDtos['+index+'].unitDto.type" class="form-control input-lg">';
    nutrientRow += '<option value="na">Measured In</option>'
    nutrientRow += '<option value="mg">Milligram</option>';
    nutrientRow += '<option value="gm">Gram</option>';
    nutrientRow += '<option value="kg">Kilogram</option>';
    nutrientRow += '</select>';
    nutrientRow += '</div>';
    nutrientRow += '</div>';
    return nutrientRow;
}