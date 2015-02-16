<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="../Include.jsp"%>
  <title>Add Product</title>
  <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/ProductHome.js"></script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div class="jumbotron" align="center">

  <form role="form" action="addnew" method="post" enctype="multipart/form-data">
  <div class="row">

    <div class="col-lg-4">
        <div class="row">
          <div class="thumbnail new-product-thumbnail">
            <input id="prodImg" style="display: none" type="file" name="prodImg"/>
            <img id="productImage" src="${pageContext.request.contextPath}/resources/images/products/NoProduct.png" alt="..." width="165">
            <span id="imageSubText">Click to add one</span>
          </div>
        </div>

    </div>
    <div class="col-xs-7 col-lg-7">
        <div class="row">
            <div class="col-lg-8 nutrients-row">
              <input name="name" type="text" class="form-control font-product-name input-lg" placeholder="Product Name" />
            </div>
            <div class="col-lg-4 nutrients-row">
              <input name="quantity" type="text" class="form-control font-product-quantity input-lg" placeholder="Quantity" />
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
  </div
  <div class="row">
    <div class="col-xs-12 col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Product Catalogue</h3>
        </div>
        <div class="panel-body">
          <c:forEach items="${products}" var="product">
            <div class="col-lg-2">
              <div class="thumbnail products-thumbnail">
                <h4>${product.name}</h4>
                <img src="fetchimage?imageId=${product.name}" alt="..." width="80">
                <div class="caption">
                  <c:forEach items="${product.nutrientDtos}" var="nutrient">
                    <c:out value="${nutrient.name}"></c:out><br>
                  </c:forEach>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>


</div>
</body>
</html>
