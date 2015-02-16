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
        <div class="col-lg-4 title-text">
          <h4>Products Consumed Today</h4>
        </div>
        <div class="col-lg-4">
          <form id="searchFrm" method="post" action="consume">
            <input id="searchBox" name="productName" type="text" class="form-control input-lg" placeholder="Product Name">
          </form>
        </div>
  </div>
  <div class="row">
      <c:forEach items="${consumptions}" var="consumption">
          <div class="col-lg-2">
              <div class="thumbnail products-thumbnail" title="Increment - Click : Decrement : Double Click">
                  <h3>${consumption.productName}</h3>
                  <img src="${pageContext.request.contextPath}/product/fetchimage?imageId=${consumption.productName}" alt="..." width="50">
                  <div class="caption">
                      <p>${consumption.quantity}</p>
                  </div>
              </div>
          </div>
      </c:forEach>

  </div>
</div>
</body>
</html>
