<%--
  Created by IntelliJ IDEA.
  User: Anand Muley
  Date: 02/01/15
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="../Include.jsp"%>
  <title>Add Food</title>
  <script type="application/javascript">
    var index = 0;
    $(document).ready(function(){
      $( "#spinner" ).spinner();

      $('#addNutrient').click(function(){
        $('#nutrientsContainer').append(fnGenerateNutrient());
      });

    });

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
  </script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div class="jumbotron" align="center">


  <div class="row">
    <div class="col-xs-8 col-lg-8">
      <div class="row">
        <div class="col-md-4 col-lg-4">
          <h2 class="heading1" style="float: left">Product</h2>
        </div>
      </div>

      <form role="form" action="addnew" method="post" enctype="multipart/form-data">
        <div class="row">
          <div class="col-xs-4 col-lg-4 nutrients-row">
            <input name="name" type="text" class="form-control food-font input-lg" placeholder="Name" />
          </div>
        </div>
        <div class="row">
          <div class="col-xs-4 col-lg-4">
            <h3 class="heading1" style="float: left">Nutrients <span id="addNutrient" class="add-nutrient-subtext">Add More+</span></h3>
          </div>
        </div>
        <div id="nutrientsContainer">
          <div class="row">
            <div class="col-xs-4 col-lg-4 nutrients-row">
              <input name="nutrientDtos[0].name" type="text" class="form-control input-lg" placeholder="Name" />
            </div>
            <div class="col-xs-4 col-lg-4 nutrients-row">
              <input name="nutrientDtos[0].unitDto.quantity" type="text" class="form-control input-lg" placeholder="Unit Value" />
            </div>
            <div class="col-xs-4 col-lg-4 nutrients-row">
              <select name="nutrientDtos[0].unitDto.type" class="form-control input-lg">
                <option value="na">Measured In</option>
                <option value="mg">Milligram</option>
                <option value="gm">Gram</option>
                <option value="kg">Kilogram</option>
              </select>
            </div>
          </div>
        </div>

        <div class="row container-save-food">
          <div class="col-xs-12 col-lg-12">
            <button type="submit" class="btn btn-lg button" href="#" role="button">Save</button>
          </div>
        </div>
      </form>

      <c:if test="${message!=null}">
        <div class="row">
          <div class="alert alert-success col-xs-12 col-lg-12">
            <c:out value="${message}"></c:out>
          </div>
        </div>

      </c:if>
    </div>
    <div class="col-xs-4 col-lg-4">
      <div class="list-group">
        <a href="#" class="list-group-item active products-panel-heading">
          <h4 class="list-group-item-heading">Product Catalogue</h4>
        </a>
        <c:forEach items="${products}" var="product">
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">${product.name}</h4>
            <p class="list-group-item-text">
              <c:forEach items="${product.nutrientDtos}" var="nutrient">
                <c:out value="${nutrient.name}:${nutrient.unitDto.quantity} ${nutrient.unitDto.type}"></c:out>
              </c:forEach>
            </p>
          </a>
        </c:forEach>

      </div>

    </div>
  </div>


</div>
</body>
</html>
