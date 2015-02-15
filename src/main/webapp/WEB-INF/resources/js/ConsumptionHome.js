$(document).ready(function(){
    var rowId = 1;
    var DomMan = new domman();
    $('#addComptionRow').click(function(){
        DomMan.createTableRow('consumptionTbody',++rowId,'ConsumptionTabRow');
    });

    $('#searchBox').autocomplete({
        source: "../product/search",
        minLength: 2
    });
});