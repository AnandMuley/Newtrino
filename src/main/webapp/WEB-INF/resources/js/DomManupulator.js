/**
 * Created by Anand Muley on 15/02/15.
 */

var domman = function (){
    function consumptionTabRow(rowId){
        var trow = '<tr>';
        trow += '<td>'+rowId+'</td>';
        trow += '<td><input id="searchBox" name="productName" type="text" class="form-control input" placeholder="Product Name"></td>';
        trow += '<td colspan="2"><input name="quantity" class="form-control input" placeholder="Quantity"/></td>';
        trow += '</tr>';
        return trow;
    }
    this.createTableRow = function createTableRow(tbodyId,rowId,template){
        if(template == 'ConsumptionTabRow'){
            $('#'+tbodyId).append(consumptionTabRow(rowId));
        }
    }
}



