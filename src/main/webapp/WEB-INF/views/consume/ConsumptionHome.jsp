<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="../Include.jsp"%>
  <title>Consumption Home</title>
  <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/ConsumptionHome.js"></script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div align="center" class="jumbotron">
  <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <div class="panel panel-default">
            <div class="panel-heading consumption-panel-heading">
              <h4>Add Product to Today's Consumption list</h4>
            </div>
            <table class="table consumption-table">
              <thead>
                <th width="10%">Sr.No</th>
                <th width="50%">Product</th>
                <th>Quantity</th>
                <th><span id="addComptionRow" class="glyphicon glyphicon-plus"></span></th>
              </thead>
              <tbody id="consumptionTbody">
                <tr>
                  <td>1</td>
                  <td>
                    <input id="searchBox" name="productName" type="text" class="form-control input" placeholder="Product Name">
                  </td>
                  <td colspan="2">
                    <input name="quantity" class="form-control input" placeholder="Quantity"/>
                  </td>
                </tr>

              </tbody>
            </table>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="list-group">
            <a href="#" class="list-group-item active products-panel-heading">
              <h4 class="list-group-item-heading consumption-panel-heading-text">Consumed Till Now</h4>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">
                Mocha Coffee <span class="list-group-item-text consumption-quantity-text">( 2 Cups )</span>
              </h4>
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
