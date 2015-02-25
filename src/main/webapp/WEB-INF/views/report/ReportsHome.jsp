<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="../Include.jsp"%>
  <title>Reports Home</title>
  <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/ProductHome.js"></script>
  <!--Load the AJAX Google Charting API-->
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
  <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/ReportsHome.js"></script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div class="jumbotron" align="center">
  <!--Div that will hold the pie chart-->
  <div id="reportsContainer" class="row">
  </div>
</div>
</body>
</html>
