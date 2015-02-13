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
  <title>Food Home</title>
</head>
<body>
<%@include file="../Navigation.jsp"%>
  <div align="center" class="jumbotron">
    <div class="container">

      <div class="starter-template">
        <h1 class="home-subtitle">Nutrients in Foods</h1>
        <p class="lead">A software helping you to be health conscious in this busy world.</p>
      </div>

    </div>
    <br><br>
    <div class="row">
      <div class="col-sm-6 col-md-2">
          <a href="add" class="thumbnail" style="text-decoration: none">
            <img class="images-bg" src="../resources/images/Food1.png" data-src="holder.js/100x100" alt="..." width="100">
            <div class="caption" align="center">
              <h3>Add New Product</h3>
            </div>
          </a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a href="add" class="thumbnail" style="text-decoration: none">
          <img class="images-bg" src="../resources/images/PieChart.png" data-src="holder.js/100x100" alt="..." width="100">
          <div class="caption" align="center">
            <h3>Consumption Pattern</h3>
          </div>
        </a>
      </div>
      <div class="col-sm-6 col-md-3">
        <a href="add" class="thumbnail" style="text-decoration: none">
          <img class="images-bg" src="../resources/images/AskExpert.png" data-src="holder.js/100x100" alt="..." width="100">
          <div class="caption" align="center">
            <h3 style="text-wrap: normal">Recommended</h3>
          </div>
        </a>
      </div>
      <div class="col-sm-6 col-md-2">
        <a href="add" class="thumbnail" style="text-decoration: none">
          <img class="images-bg" src="../resources/images/Consumed.png" data-src="holder.js/100x100" alt="..." width="100">
          <div class="caption" align="center">
            <h3>Consumed</h3>
          </div>
        </a>
      </div>
      <div class="col-sm-6 col-md-2">
        <a href="add" class="thumbnail" style="text-decoration: none">
          <img class="images-bg" src="../resources/images/CurrentStatus.png" data-src="holder.js/100x100" alt="..." width="100">
          <div class="caption" align="center">
            <h3>Current Status</h3>
          </div>
        </a>
      </div>
    </div>

  </div>
</body>
</html>
