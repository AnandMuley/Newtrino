$(document).ready(function(){
    var rowId = 1;
    var DomMan = new domman();
    $('#addComptionRow').click(function(){
        DomMan.createTableRow('consumptionTbody',++rowId,'ConsumptionTabRow');
    });

    $('#searchBox').autocomplete({
        source: "../product/search",
        minLength: 2,
        select: function( event, ui ) {
            $('#searchBox').val(ui.item.value);
            $('#searchFrm').submit();
        }
    });

    $('.consumedProd').mousedown(function(e){
        // Title : this.title
        var title = this.title;
        switch (e.which){
            case 1:
                // left click
                // Increment Consumption Count
                $.ajax({
                    type : "POST",
                    url : "changequantity",
                    data : {pname:title,opr:1}
                }).done(function(msg){
                    $('#'+title).html(msg.quantity);
                });
                break;
            case 2:
                // middle click
                // Decrement Consumption
                $.ajax({
                    type : "POST",
                    url : "changequantity",
                    data : {pname:title,opr:-1}
                }).done(function(msg){
                    $('#'+title).html(msg.quantity);
                });
                break;
        }

    });

});