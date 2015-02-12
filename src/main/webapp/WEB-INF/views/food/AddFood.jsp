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
    $(document).ready(function(){
      $( "#spinner" ).spinner();

      $('#addNutrient').click(function(){
        $('#nutrientsContainer').append(fnGenerateNutrient());
      });

    });

    function fnGenerateNutrient(){
      var nutrientRow = '<div class="row">';
      nutrientRow += '<div class="col-xs-6 col-lg-3 nutrients-row">';
      nutrientRow += '</div>';
      nutrientRow += '<div class="col-xs-6 col-lg-3 nutrients-row">';
      nutrientRow += '</div>';
      nutrientRow += '<div class="col-xs-6 col-lg-3 nutrients-row">';
      nutrientRow += '<input name="title" type="text" class="form-control input-lg" placeholder="Nutrient Name" />';
      nutrientRow += '</div>';
      nutrientRow += '<div class="col-xs-6 col-lg-3 nutrients-row">';
      nutrientRow += '<input name="title" type="text" class="form-control input-lg" placeholder="Nutrient Quantity" />';
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
    <div class="col-md-3">
      <h2 class="color-brown" style="float: left">Food <img class="food-burger" src="${pageContext.request.contextPath}/resources/css/images/food/burger.png"></h2>
    </div>
  </div>

  <form role="form" action="create" method="post" enctype="multipart/form-data">
    <div class="row">
      <div class="col-xs-6 col-lg-6 nutrients-row">
        <input name="title" type="text" class="form-control food-font input-lg" placeholder="Name" />
      </div>
      <div class="col-xs-6 col-lg-6 nutrients-row">
        <input name="title" type="text" class="form-control food-font input-lg" placeholder="Quantity" />
      </div>
    </div>
    <div class="row">
      <div class="col-xs-2 col-lg-6">
        <h3 class="font-orange" style="float:left">Energy <small class="font-orange">per 100g</small><span class="glyphicon glyphicon-fire font-orange font-large"></span></h3>
      </div>
      <div class="col-xs-2 col-lg-3">
        <h3 class="font-blue" style="float: left">Nutrients <small class="font-blue">per 100g</small> <img id="addNutrient" class="food-protein" src="${pageContext.request.contextPath}/resources/css/images/food/protein.png"></h3>
      </div>
    </div>
    <div id="nutrientsContainer">
      <div class="row">
        <div class="col-xs-6 col-lg-3 nutrients-row">
          <input name="title" type="text" class="form-control input-lg" placeholder="KiloJoules(KJ)" />
        </div>
        <div class="col-xs-6 col-lg-3 nutrients-row">
          <input name="title" type="text" class="form-control input-lg" placeholder="KiloCalories(KCal)" />
        </div>
        <div class="col-xs-6 col-lg-3 nutrients-row">
          <input name="title" type="text" class="form-control input-lg" placeholder="Nutrient Name" />
        </div>
        <div class="col-xs-6 col-lg-3 nutrients-row">
          <input name="title" type="text" class="form-control input-lg" placeholder="Nutrient Quantity" />
        </div>

      </div>
    </div>

    <div class="row container-save-food">
      <div class="col-md-12">
        <button type="submit" class="btn btn-lg btn-success" href="#" role="button">Save</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
