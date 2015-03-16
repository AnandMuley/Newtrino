<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="Include.jsp"%>
  <title>Login</title>
  <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/Registration.js"></script>

</head>
<body>
<div class="jumbotron" align="center">

  <form role="form" action="login" method="post" enctype="multipart/form-data">
    <div class="row">
      <div class="col-lg-12">
        <h2>Login</h2>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
        <input name="u" type="text" class="form-control input-lg" placeholder="Username" />
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
        <input name="p" type="password" class="form-control input-lg" placeholder="Password" />
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-xs-12 col-lg-12">
        <button type="submit" class="btn btn-lg button" href="#" role="button">Login</button>
      </div>
    </div>
  </form>
  <div class="row container-save-food">
    <div class="col-xs-12 col-lg-12">
      <a href="register">Register</a>
    </div>
  </div>

</div>
</body>
</html>

